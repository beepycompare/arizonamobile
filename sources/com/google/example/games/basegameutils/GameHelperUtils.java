package com.google.example.games.basegameutils;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.content.res.Resources;
import android.util.Log;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
/* loaded from: classes4.dex */
class GameHelperUtils {
    private static final String[] FALLBACK_STRINGS = {"*Unknown error.", "*Failed to sign in. Please check your network connection and try again.", "*The application is incorrectly configured. Check that the package name and signing certificate match the client ID created in Developer Console. Also, if the application is not yet published, check that the account you are trying to sign in with is listed as a tester account. See logs for more information.", "*License check failed."};
    private static final String[] RES_STRS = {"An unknown error occurred.", "Failed to sign in. Please check your network connection and try again.", "App is misconfigured.", "License check failed."};
    public static final int R_APP_MISCONFIGURED = 2;
    public static final int R_LICENSE_FAILED = 3;
    public static final int R_SIGN_IN_FAILED = 1;
    public static final int R_UNKNOWN_ERROR = 0;

    GameHelperUtils() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String activityResponseCodeToString(int i) {
        if (i != -1) {
            if (i != 0) {
                switch (i) {
                    case 10001:
                        return "RESULT_RECONNECT_REQUIRED";
                    case 10002:
                        return "SIGN_IN_FAILED";
                    case 10003:
                        return "RESULT_LICENSE_FAILED";
                    case 10004:
                        return "RESULT_APP_MISCONFIGURED";
                    case 10005:
                        return "RESULT_LEFT_ROOM";
                    default:
                        return String.valueOf(i);
                }
            }
            return "RESULT_CANCELED";
        }
        return "RESULT_OK";
    }

    /* JADX WARN: Code restructure failed: missing block: B:0:?, code lost:
        r4 = r4;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    static void byteToString(StringBuilder sb, byte b) {
        int i;
        if (b < 0) {
            i = b + 256;
        }
        int i2 = i / 16;
        int i3 = i % 16;
        sb.append("0123456789ABCDEF".substring(i2, i2 + 1));
        sb.append("0123456789ABCDEF".substring(i3, i3 + 1));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String errorCodeToString(int i) {
        StringBuilder sb;
        StringBuilder append;
        switch (i) {
            case 0:
                sb = new StringBuilder("SUCCESS(");
                append = sb.append(i).append(")");
                break;
            case 1:
                sb = new StringBuilder("SERVICE_MISSING(");
                append = sb.append(i).append(")");
                break;
            case 2:
                sb = new StringBuilder("SERVICE_VERSION_UPDATE_REQUIRED(");
                append = sb.append(i).append(")");
                break;
            case 3:
                sb = new StringBuilder("SERVICE_DISABLED(");
                append = sb.append(i).append(")");
                break;
            case 4:
                sb = new StringBuilder("SIGN_IN_REQUIRED(");
                append = sb.append(i).append(")");
                break;
            case 5:
                sb = new StringBuilder("INVALID_ACCOUNT(");
                append = sb.append(i).append(")");
                break;
            case 6:
                sb = new StringBuilder("RESOLUTION_REQUIRED(");
                append = sb.append(i).append(")");
                break;
            case 7:
                sb = new StringBuilder("NETWORK_ERROR(");
                append = sb.append(i).append(")");
                break;
            case 8:
                sb = new StringBuilder("INTERNAL_ERROR(");
                append = sb.append(i).append(")");
                break;
            case 9:
                sb = new StringBuilder("SERVICE_INVALID(");
                append = sb.append(i).append(")");
                break;
            case 10:
                sb = new StringBuilder("DEVELOPER_ERROR(");
                append = sb.append(i).append(")");
                break;
            case 11:
                sb = new StringBuilder("LICENSE_CHECK_FAILED(");
                append = sb.append(i).append(")");
                break;
            default:
                append = new StringBuilder("Unknown error code ").append(i);
                break;
        }
        return append.toString();
    }

    static String getAppIdFromResource(Context context) {
        try {
            Resources resources = context.getResources();
            return resources.getString(resources.getIdentifier("app_id", TypedValues.Custom.S_STRING, context.getPackageName()));
        } catch (Exception e) {
            e.printStackTrace();
            return "??? (failed to retrieve APP ID)";
        }
    }

    static String getSHA1CertFingerprint(Context context) {
        try {
            Signature[] signatureArr = context.getPackageManager().getPackageInfo(context.getPackageName(), 64).signatures;
            if (signatureArr.length == 0) {
                return "ERROR: NO SIGNATURE.";
            }
            if (signatureArr.length > 1) {
                return "ERROR: MULTIPLE SIGNATURES";
            }
            byte[] digest = MessageDigest.getInstance("SHA1").digest(signatureArr[0].toByteArray());
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < digest.length; i++) {
                if (i > 0) {
                    sb.append(StringUtils.PROCESS_POSTFIX_DELIMITER);
                }
                byteToString(sb, digest[i]);
            }
            return sb.toString();
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return "(ERROR: package not found)";
        } catch (NoSuchAlgorithmException e2) {
            e2.printStackTrace();
            return "(ERROR: SHA1 algorithm not found)";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String getString(Context context, int i) {
        return RES_STRS[(i < 0 || i >= RES_STRS.length) ? 0 : 0];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void printMisconfiguredDebugInfo(Context context) {
        String str;
        Log.w("GameHelper", "****");
        Log.w("GameHelper", "****");
        Log.w("GameHelper", "**** APP NOT CORRECTLY CONFIGURED TO USE GOOGLE PLAY GAME SERVICES");
        Log.w("GameHelper", "**** This is usually caused by one of these reasons:");
        Log.w("GameHelper", "**** (1) Your package name and certificate fingerprint do not match");
        Log.w("GameHelper", "****     the client ID you registered in Developer Console.");
        Log.w("GameHelper", "**** (2) Your App ID was incorrectly entered.");
        Log.w("GameHelper", "**** (3) Your game settings have not been published and you are ");
        Log.w("GameHelper", "****     trying to log in with an account that is not listed as");
        Log.w("GameHelper", "****     a test account.");
        Log.w("GameHelper", "****");
        if (context == null) {
            str = "*** (no Context, so can't print more debug info)";
        } else {
            Log.w("GameHelper", "**** To help you debug, here is the information about this app");
            Log.w("GameHelper", "**** Package name         : " + context.getPackageName());
            Log.w("GameHelper", "**** Cert SHA1 fingerprint: " + getSHA1CertFingerprint(context));
            Log.w("GameHelper", "**** App ID from          : " + getAppIdFromResource(context));
            Log.w("GameHelper", "****");
            Log.w("GameHelper", "**** Check that the above information matches your setup in ");
            Log.w("GameHelper", "**** Developer Console. Also, check that you're logging in with the");
            Log.w("GameHelper", "**** right account (it should be listed in the Testers section if");
            Log.w("GameHelper", "**** your project is not yet published).");
            Log.w("GameHelper", "****");
            Log.w("GameHelper", "**** For more information, refer to the troubleshooting guide:");
            str = "****   http://developers.google.com/games/services/android/troubleshooting";
        }
        Log.w("GameHelper", str);
    }
}
