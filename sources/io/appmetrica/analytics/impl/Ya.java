package io.appmetrica.analytics.impl;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import java.util.concurrent.Callable;
/* loaded from: classes4.dex */
public final class Ya implements Callable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Za f751a;

    public Ya(Za za) {
        this.f751a = za;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        Uri parse = Uri.parse("content://com.huawei.appmarket.commondata/item/5");
        ContentResolver contentResolver = this.f751a.f768a.getContentResolver();
        Za za = this.f751a;
        za.b = contentResolver.query(parse, null, null, new String[]{za.f768a.getPackageName()}, null);
        Cursor cursor = this.f751a.b;
        if (cursor == null || !cursor.moveToFirst()) {
            return null;
        }
        String string = this.f751a.b.getString(0);
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        return new Jg(string, this.f751a.b.getLong(1), this.f751a.b.getLong(2), Ig.d);
    }
}
