package io.appmetrica.analytics.impl;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import java.util.concurrent.Callable;
/* loaded from: classes4.dex */
public final class Va implements Callable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Wa f692a;

    public Va(Wa wa) {
        this.f692a = wa;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        Uri parse = Uri.parse("content://com.huawei.appmarket.commondata/item/5");
        ContentResolver contentResolver = this.f692a.f707a.getContentResolver();
        Wa wa = this.f692a;
        wa.b = contentResolver.query(parse, null, null, new String[]{wa.f707a.getPackageName()}, null);
        Cursor cursor = this.f692a.b;
        if (cursor == null || !cursor.moveToFirst()) {
            return null;
        }
        String string = this.f692a.b.getString(0);
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        return new Fg(string, this.f692a.b.getLong(1), this.f692a.b.getLong(2), Eg.d);
    }
}
