package io.appmetrica.analytics.impl;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import java.util.concurrent.Callable;
/* loaded from: classes4.dex */
public final class Ra implements Callable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Sa f607a;

    public Ra(Sa sa) {
        this.f607a = sa;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        Uri parse = Uri.parse("content://com.huawei.appmarket.commondata/item/5");
        ContentResolver contentResolver = this.f607a.f624a.getContentResolver();
        Sa sa = this.f607a;
        sa.b = contentResolver.query(parse, null, null, new String[]{sa.f624a.getPackageName()}, null);
        Cursor cursor = this.f607a.b;
        if (cursor == null || !cursor.moveToFirst()) {
            return null;
        }
        String string = this.f607a.b.getString(0);
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        return new C0733yg(string, this.f607a.b.getLong(1), this.f607a.b.getLong(2), EnumC0708xg.d);
    }
}
