package io.appmetrica.analytics.screenshot.impl;

import android.database.ContentObserver;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
import io.appmetrica.analytics.coreutils.internal.time.SystemTimeProvider;
import io.appmetrica.analytics.modulesapi.internal.client.ClientContext;
import java.util.Collection;
import java.util.Locale;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function0;
import kotlin.text.StringsKt;
/* loaded from: classes5.dex */
public final class Z extends ContentObserver {
    public static final String d = MediaStore.Images.Media.EXTERNAL_CONTENT_URI.toString();

    /* renamed from: a  reason: collision with root package name */
    public final ClientContext f1465a;
    public final Function0 b;
    public volatile C0771k c;

    public Z(ClientContext clientContext, C0778s c0778s) {
        super(clientContext.getClientExecutorProvider().getDefaultExecutor().getHandler());
        this.f1465a = clientContext;
        this.b = c0778s;
    }

    @Override // android.database.ContentObserver
    public final void onChange(boolean z, Uri uri) {
        C0771k c0771k;
        super.onChange(z, uri);
        if (!StringsKt.startsWith$default(String.valueOf(uri), d, false, 2, (Object) null) || (c0771k = this.c) == null) {
            return;
        }
        try {
            String[] strArr = (String[]) ArraysKt.plus((Object[]) new String[]{"date_added"}, (Collection) c0771k.b);
            Cursor query = this.f1465a.getContext().getContentResolver().query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, strArr, "date_added >= ?", new String[]{String.valueOf(new SystemTimeProvider().currentTimeSeconds() - c0771k.c)}, "date_added DESC");
            if (query != null && query.moveToFirst()) {
                for (String str : strArr) {
                }
                for (String str2 : c0771k.b) {
                    if (StringsKt.contains$default((CharSequence) query.getString(query.getColumnIndexOrThrow(str2)).toLowerCase(Locale.ROOT), (CharSequence) "screenshot", false, 2, (Object) null)) {
                        this.b.invoke();
                    }
                }
            }
            Unit unit = Unit.INSTANCE;
            CloseableKt.closeFinally(query, null);
        } catch (Exception unused) {
        }
    }
}
