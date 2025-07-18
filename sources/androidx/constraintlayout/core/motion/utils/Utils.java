package androidx.constraintlayout.core.motion.utils;

import io.appmetrica.analytics.coreutils.internal.StringUtils;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Arrays;
/* loaded from: classes2.dex */
public class Utils {
    static DebugHandle sOurHandle;

    /* loaded from: classes2.dex */
    public interface DebugHandle {
        void message(String str);
    }

    private static int clamp(int i) {
        int i2 = (i & (~(i >> 31))) - 255;
        return (i2 & (i2 >> 31)) + 255;
    }

    public static void log(String str, String str2) {
        System.out.println(str + " : " + str2);
    }

    public static void loge(String str, String str2) {
        System.err.println(str + " : " + str2);
    }

    public static void socketSend(String str) {
        try {
            OutputStream outputStream = new Socket("127.0.0.1", 5327).getOutputStream();
            outputStream.write(str.getBytes());
            outputStream.close();
        } catch (IOException e) {
            System.err.println(e.toString() + "\n" + Arrays.toString(e.getStackTrace()).replace("[", "   at ").replace(StringUtils.COMMA, "\n   at").replace("]", ""));
        }
    }

    public int getInterpolatedColor(float[] fArr) {
        int clamp = clamp((int) (((float) Math.pow(fArr[0], 0.45454545454545453d)) * 255.0f));
        int clamp2 = clamp((int) (((float) Math.pow(fArr[1], 0.45454545454545453d)) * 255.0f));
        return (clamp((int) (fArr[3] * 255.0f)) << 24) | (clamp << 16) | (clamp2 << 8) | clamp((int) (((float) Math.pow(fArr[2], 0.45454545454545453d)) * 255.0f));
    }

    public static int rgbaTocColor(float f, float f2, float f3, float f4) {
        int clamp = clamp((int) (f * 255.0f));
        int clamp2 = clamp((int) (f2 * 255.0f));
        return (clamp << 16) | (clamp((int) (f4 * 255.0f)) << 24) | (clamp2 << 8) | clamp((int) (f3 * 255.0f));
    }

    public static void setDebugHandle(DebugHandle debugHandle) {
        sOurHandle = debugHandle;
    }

    public static void logStack(String str, int i) {
        StackTraceElement[] stackTrace = new Throwable().getStackTrace();
        int min = Math.min(i, stackTrace.length - 1);
        String str2 = " ";
        for (int i2 = 1; i2 <= min; i2++) {
            StackTraceElement stackTraceElement = stackTrace[i2];
            str2 = str2 + " ";
            System.out.println(str + str2 + (".(" + stackTraceElement.getFileName() + StringUtils.PROCESS_POSTFIX_DELIMITER + stackTraceElement.getLineNumber() + ") " + stackTraceElement.getMethodName()) + str2);
        }
    }

    public static void log(String str) {
        StackTraceElement stackTraceElement = new Throwable().getStackTrace()[1];
        String str2 = ".(" + stackTraceElement.getFileName() + StringUtils.PROCESS_POSTFIX_DELIMITER + stackTraceElement.getLineNumber() + ")" + "    ".substring(Integer.toString(stackTraceElement.getLineNumber()).length()) + (stackTraceElement.getMethodName() + "                  ").substring(0, 17);
        System.out.println(str2 + " " + str);
        DebugHandle debugHandle = sOurHandle;
        if (debugHandle != null) {
            debugHandle.message(str2 + " " + str);
        }
    }
}
