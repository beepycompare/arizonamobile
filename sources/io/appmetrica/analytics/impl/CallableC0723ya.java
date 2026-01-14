package io.appmetrica.analytics.impl;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import java.util.concurrent.Callable;
/* renamed from: io.appmetrica.analytics.impl.ya  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class CallableC0723ya implements Callable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0748za f1320a;

    public CallableC0723ya(C0748za c0748za) {
        this.f1320a = c0748za;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        Uri parse = Uri.parse("content://com.huawei.appmarket.commondata/item/5");
        ContentResolver contentResolver = this.f1320a.f1332a.getContentResolver();
        C0748za c0748za = this.f1320a;
        c0748za.b = contentResolver.query(parse, null, null, new String[]{c0748za.f1332a.getPackageName()}, null);
        Cursor cursor = this.f1320a.b;
        if (cursor == null || !cursor.moveToFirst()) {
            return null;
        }
        String string = this.f1320a.b.getString(0);
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        return new C0455ng(string, this.f1320a.b.getLong(1), this.f1320a.b.getLong(2), EnumC0430mg.d);
    }
}
