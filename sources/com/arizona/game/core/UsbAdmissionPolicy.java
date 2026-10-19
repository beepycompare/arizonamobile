package com.arizona.game.core;
/* loaded from: classes3.dex */
final class UsbAdmissionPolicy {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean failureBelongsToCurrent(long j, long j2) {
        return j == j2;
    }

    private UsbAdmissionPolicy() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean responseMatches(boolean z, long j, long j2, long j3, String str, String str2) {
        return z && str != null && j3 == j && j3 == j2 && str.equals(str2);
    }
}
