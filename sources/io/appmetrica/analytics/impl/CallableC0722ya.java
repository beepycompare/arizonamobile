package io.appmetrica.analytics.impl;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import java.util.concurrent.Callable;
/* renamed from: io.appmetrica.analytics.impl.ya  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class CallableC0722ya implements Callable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0747za f1324a;

    public CallableC0722ya(C0747za c0747za) {
        this.f1324a = c0747za;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        Uri parse = Uri.parse("content://com.huawei.appmarket.commondata/item/5");
        ContentResolver contentResolver = this.f1324a.f1336a.getContentResolver();
        C0747za c0747za = this.f1324a;
        c0747za.b = contentResolver.query(parse, null, null, new String[]{c0747za.f1336a.getPackageName()}, null);
        Cursor cursor = this.f1324a.b;
        if (cursor == null || !cursor.moveToFirst()) {
            return null;
        }
        String string = this.f1324a.b.getString(0);
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        return new C0454ng(string, this.f1324a.b.getLong(1), this.f1324a.b.getLong(2), EnumC0429mg.d);
    }
}
