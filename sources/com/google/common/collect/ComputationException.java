package com.google.common.collect;

import javax.annotation.CheckForNull;
@ElementTypesAreNonnullByDefault
@Deprecated
/* loaded from: classes4.dex */
public class ComputationException extends RuntimeException {
    private static final long serialVersionUID = 0;

    public ComputationException(@CheckForNull Throwable cause) {
        super(cause);
    }
}
