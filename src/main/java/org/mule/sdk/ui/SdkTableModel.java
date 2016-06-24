package org.mule.sdk.ui;

import com.intellij.util.ui.ColumnInfo;
import com.intellij.util.ui.ListTableModel;
import org.jetbrains.annotations.Nullable;
import org.mule.sdk.MuleSdk;

public class SdkTableModel extends ListTableModel<MuleSdk>
{
    public SdkTableModel()
    {
        super(new ColumnInfo<MuleSdk, String>("Location")
        {
            @Nullable
            @Override
            public String valueOf(MuleSdk sdkChoice)
            {
                return sdkChoice.getMuleHome();
            }


        }, new ColumnInfo<MuleSdk, String>("Version")
        {
            @Nullable
            @Override
            public String valueOf(MuleSdk sdkChoice)
            {
                return sdkChoice.getVersion();
            }
        });
    }
}
