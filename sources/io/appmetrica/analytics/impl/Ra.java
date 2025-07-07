package io.appmetrica.analytics.impl;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import java.util.concurrent.Callable;
/* loaded from: classes4.dex */
public final class Ra implements Callable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Sa f606a;

    public Ra(Sa sa) {
        this.f606a = sa;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        Uri parse = Uri.parse("content://com.huawei.appmarket.commondata/item/5");
        ContentResolver contentResolver = this.f606a.f623a.getContentResolver();
        Sa sa = this.f606a;
        sa.b = contentResolver.query(parse, null, null, new String[]{sa.f623a.getPackageName()}, null);
        Cursor cursor = this.f606a.b;
        if (cursor == null || !cursor.moveToFirst()) {
            return null;
        }
        String string = this.f606a.b.getString(0);
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        return new C0741yg(string, this.f606a.b.getLong(1), this.f606a.b.getLong(2), EnumC0716xg.d);
    }
}
