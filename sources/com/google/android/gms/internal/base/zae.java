package com.google.android.gms.internal.base;

import android.graphics.drawable.Drawable;
/* compiled from: com.google.android.gms:play-services-base@@18.9.0 */
/* loaded from: classes4.dex */
final class zae extends Drawable.ConstantState {
    private zae() {
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zae(byte[] bArr) {
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public final int getChangingConfigurations() {
        return 0;
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public final Drawable newDrawable() {
        return zaf.zaa();
    }
}
