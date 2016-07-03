/*
 * Copyright 2000-2013 JetBrains s.r.o.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.mule.tooling.esb.sdk;

import com.intellij.openapi.components.PersistentStateComponent;
import com.intellij.openapi.components.State;
import com.intellij.openapi.components.Storage;
import com.intellij.openapi.diagnostic.Logger;
import com.intellij.util.xmlb.SkipDefaultValuesSerializationFilters;
import com.intellij.util.xmlb.XmlSerializationException;
import com.intellij.util.xmlb.XmlSerializer;
import org.jdom.Element;
import org.jetbrains.annotations.Nullable;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@State(
        name = "MuleSdk",
        storages = {@Storage(value = "mule.xml")}
)
public class MuleSdkManagerImpl extends MuleSdkManager implements PersistentStateComponent<Element>
{
    private static final Logger LOG = Logger.getInstance("#MuleSdkManagerImpl");


    private Set<MuleSdk> sdks = new HashSet<>();

    @Nullable
    @Override
    public Element getState()
    {
        Element element = new Element("mule-sdks");
        try
        {
            for (MuleSdk sdk : sdks)
            {
                final Element sdkElement = new Element("mule-sdk");
                XmlSerializer.serializeInto(sdk, sdkElement, new SkipDefaultValuesSerializationFilters());
                element.addContent(sdkElement);
            }
        }
        catch (XmlSerializationException e)
        {
            LOG.error(e);
        }
        return element;
    }

    @Override
    public void loadState(Element state)
    {
        final List<Element> children = state.getChildren();
        for (Element child : children)
        {
            try
            {
                final MuleSdk deserialize = XmlSerializer.deserialize(child, MuleSdk.class);
                if (deserialize != null && deserialize.getMuleHome() != null)
                {
                    sdks.add(deserialize);
                }
            }
            catch (XmlSerializationException e)
            {
                LOG.error(e);
            }
        }
    }

    @Override
    public MuleSdk findSdk(String sdkHomePath)
    {
        for (MuleSdk muleSdk : sdks)
        {
            if (sdkHomePath.equals(muleSdk.getMuleHome()))
            {
                return muleSdk;
            }
        }
        return null;
    }

    @Override
    public Set<MuleSdk> getSdks()
    {
        return sdks;
    }

    @Override
    public void addSdk(MuleSdk muleSdk)
    {
        this.sdks.add(muleSdk);
    }

    @Override
    public MuleSdk findFromVersion(String muleVersion)
    {
        for (MuleSdk sdk : sdks)
        {
            if (sdk.getVersion().equals(muleVersion))
            {
                return sdk;
            }
        }
        return null;
    }

    @Override
    public void removeSdk(MuleSdk selectedObject)
    {
        sdks.remove(selectedObject);
    }
}
