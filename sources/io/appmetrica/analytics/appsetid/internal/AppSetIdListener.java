package io.appmetrica.analytics.appsetid.internal;

import androidx.media3.extractor.text.ttml.TtmlNode;
import io.appmetrica.analytics.coreapi.internal.identifiers.AppSetIdScope;
import kotlin.Metadata;
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0012\u0010\b\u001a\u00020\u00032\b\u0010\t\u001a\u0004\u0018\u00010\nH&¨\u0006\u000b"}, d2 = {"Lio/appmetrica/analytics/appsetid/internal/AppSetIdListener;", "", "onAppSetIdRetrieved", "", TtmlNode.ATTR_ID, "", "scope", "Lio/appmetrica/analytics/coreapi/internal/identifiers/AppSetIdScope;", "onFailure", "ex", "", "appsetid_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public interface AppSetIdListener {
    void onAppSetIdRetrieved(String str, AppSetIdScope appSetIdScope);

    void onFailure(Throwable th);
}
