package io.appmetrica.analytics.impl;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import java.util.concurrent.Callable;
/* renamed from: io.appmetrica.analytics.impl.za  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class CallableC0744za implements Callable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Aa f1314a;

    public CallableC0744za(Aa aa) {
        this.f1314a = aa;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        Uri parse = Uri.parse("content://com.huawei.appmarket.commondata/item/5");
        ContentResolver contentResolver = this.f1314a.f477a.getContentResolver();
        Aa aa = this.f1314a;
        aa.b = contentResolver.query(parse, null, null, new String[]{aa.f477a.getPackageName()}, null);
        Cursor cursor = this.f1314a.b;
        if (cursor == null || !cursor.moveToFirst()) {
            return null;
        }
        String string = this.f1314a.b.getString(0);
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        return new C0476og(string, this.f1314a.b.getLong(1), this.f1314a.b.getLong(2), EnumC0451ng.d);
    }
}
