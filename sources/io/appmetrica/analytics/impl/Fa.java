package io.appmetrica.analytics.impl;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import java.util.concurrent.Callable;
/* loaded from: classes3.dex */
public final class Fa implements Callable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Ga f474a;

    public Fa(Ga ga) {
        this.f474a = ga;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        Uri parse = Uri.parse("content://com.huawei.appmarket.commondata/item/5");
        ContentResolver contentResolver = this.f474a.f489a.getContentResolver();
        Ga ga = this.f474a;
        ga.b = contentResolver.query(parse, null, null, new String[]{ga.f489a.getPackageName()}, null);
        Cursor cursor = this.f474a.b;
        if (cursor == null || !cursor.moveToFirst()) {
            return null;
        }
        String string = this.f474a.b.getString(0);
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        return new C0576sg(string, this.f474a.b.getLong(1), this.f474a.b.getLong(2), EnumC0551rg.d);
    }
}
