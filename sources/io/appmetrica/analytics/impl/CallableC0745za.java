package io.appmetrica.analytics.impl;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import java.util.concurrent.Callable;
/* renamed from: io.appmetrica.analytics.impl.za  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class CallableC0745za implements Callable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Aa f1231a;

    public CallableC0745za(Aa aa) {
        this.f1231a = aa;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        Uri parse = Uri.parse("content://com.huawei.appmarket.commondata/item/5");
        ContentResolver contentResolver = this.f1231a.f394a.getContentResolver();
        Aa aa = this.f1231a;
        aa.b = contentResolver.query(parse, null, null, new String[]{aa.f394a.getPackageName()}, null);
        Cursor cursor = this.f1231a.b;
        if (cursor == null || !cursor.moveToFirst()) {
            return null;
        }
        String string = this.f1231a.b.getString(0);
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        return new C0477og(string, this.f1231a.b.getLong(1), this.f1231a.b.getLong(2), EnumC0452ng.d);
    }
}
