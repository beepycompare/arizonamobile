package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.appsetid.internal.AppSetIdListener;
import io.appmetrica.analytics.appsetid.internal.IAppSetIdRetriever;
/* loaded from: classes5.dex */
public final class U7 implements IAppSetIdRetriever {
    @Override // io.appmetrica.analytics.appsetid.internal.IAppSetIdRetriever
    public final void retrieveAppSetId(Context context, AppSetIdListener appSetIdListener) {
        appSetIdListener.onFailure(new IllegalStateException("No App Set ID library"));
    }
}
