package ru.mrlargha.feature.battlepassWinter2025.utils;

import kotlin.Metadata;
/* compiled from: ArizonaMissionHelpers.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0006\u001a\u00020\u0005J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0005J\u0006\u0010\n\u001a\u00020\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lru/mrlargha/feature/battlepassWinter2025/utils/AsyncLoadGeneration;", "", "<init>", "()V", "generation", "", "next", "isCurrent", "", "token", "current", "battle-pass"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class AsyncLoadGeneration {
    private volatile int generation;

    public final int next() {
        int i;
        synchronized (this) {
            this.generation++;
            i = this.generation;
        }
        return i;
    }

    public final boolean isCurrent(int i) {
        boolean z;
        synchronized (this) {
            z = i == this.generation;
        }
        return z;
    }

    public final int current() {
        int i;
        synchronized (this) {
            i = this.generation;
        }
        return i;
    }
}
