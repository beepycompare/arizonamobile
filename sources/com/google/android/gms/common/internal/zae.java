package com.google.android.gms.common.internal;

import java.util.Collections;
import java.util.Set;
/* compiled from: com.google.android.gms:play-services-base@@18.9.0 */
/* loaded from: classes4.dex */
public final class zae {
    public final Set zaa;

    public zae(Set set) {
        Preconditions.checkNotNull(set);
        this.zaa = Collections.unmodifiableSet(set);
    }
}
