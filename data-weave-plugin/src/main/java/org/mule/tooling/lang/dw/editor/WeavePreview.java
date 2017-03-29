package org.mule.tooling.lang.dw.editor;

import com.intellij.openapi.diagnostic.Logger;
import com.intellij.openapi.module.Module;
import com.mulesoft.weave.lang.PreviewRunner;
import org.mule.tooling.lang.dw.util.ClasspathUtils;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by eberman on 11/10/16.
 */
public class WeavePreview {

    final static Logger logger = Logger.getInstance(WeavePreview.class);

    /**
     *
     * @param dwDocument DW Script to run
     * @param payload Key: Content-Type ; Value: payload String
     * @param flowVars Key: Name; Value: Map of Key Content-Type ; Value: variable String. Other params are the same structure
     * @return Key: Content-Type ; Value: mapped payload String
     */
    public static String runPreview(Module module,
                                    String dwDocument,
                                    Map<String, Object> payload,
                                    Map<String, Map<String, Object>> flowVars,
                                    Map<String, Map<String, Object>> sessionVars,
                                    Map<String, Map<String, Object>> inbound,
                                    Map<String, Map<String, Object>> outbound,
                                    Map<String, Map<String, Object>> recordVars,
                                    List<String> functions
                                    ) {
        String result = "";

        final Thread currentThread = Thread.currentThread();
        final ClassLoader old = currentThread.getContextClassLoader();

        try {
            ClassLoader weaveClassLoader = ClasspathUtils.getModuleClassLoader(module, WeavePreview.class.getClassLoader());
            currentThread.setContextClassLoader(weaveClassLoader);
            /*
            Class<?> clazz = weaveClassLoader.loadClass("com.mulesoft.weave.lang.PreviewRunner");

            Method method = clazz.getMethod("runPreview", String.class, Map.class, Map.class, Map.class, Map.class, Map.class, Map.class, List.class);
            Thread.yield();
            Map<String, Object> runPreview = (Map<String, Object>) method.invoke(null, dwDocument, payload, flowVars, sessionVars, inbound, outbound, recordVars, functions);
            */
            final Map<String, Object> runPreview = PreviewRunner.runPreview(dwDocument, payload, flowVars, sessionVars, inbound, outbound, recordVars, functions);
            logger.debug("RunPreview is " + runPreview);
            if (runPreview.containsKey(PreviewRunner.result_key())) {
                result = runPreview.get(PreviewRunner.result_key()).toString();
            } else if (runPreview.containsKey(PreviewRunner.message_key())) {
                result = runPreview.get(PreviewRunner.message_key()).toString();
                if (runPreview.containsKey("exceptionMessage")) {
                    result = result + "\n" + runPreview.get("exceptionMessage").toString();
                }
            }

        } catch (Exception e) {
            logger.debug(e);
            if (e != null) {
                if (e.getCause() != null)
                    result = e.getCause().getMessage();
                else
                    result = e.getMessage();
            }
        } finally {
            Thread.currentThread().setContextClassLoader(old);
        }


        return result;
    }


    public static Map<String, Object> createContent(String type, Object data) {
        final HashMap<String, Object> result = new HashMap<>();
        result.put(PreviewRunner.contentType_key(), type);
        result.put(PreviewRunner.sampleData_key(), data);
        return result;
    }


}
