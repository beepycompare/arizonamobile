package com.arkivanov.essenty.backhandler;

import java.util.Comparator;
import java.util.List;
import java.util.ListIterator;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: Utils.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u001c\n\u0000\u001a\u0014\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\b\u0012\u0004\u0012\u00020\u00010\u0002H\u0000¨\u0006\u0003"}, d2 = {"findMostImportant", "Lcom/arkivanov/essenty/backhandler/BackCallback;", "", "back-handler_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class UtilsKt {
    public static final BackCallback findMostImportant(Iterable<? extends BackCallback> iterable) {
        Object obj;
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        List sortedWith = CollectionsKt.sortedWith(iterable, new Comparator() { // from class: com.arkivanov.essenty.backhandler.UtilsKt$findMostImportant$$inlined$sortedBy$1
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                return ComparisonsKt.compareValues(Integer.valueOf(((BackCallback) t).getPriority()), Integer.valueOf(((BackCallback) t2).getPriority()));
            }
        });
        ListIterator listIterator = sortedWith.listIterator(sortedWith.size());
        while (true) {
            if (!listIterator.hasPrevious()) {
                obj = null;
                break;
            }
            obj = listIterator.previous();
            if (((BackCallback) obj).isEnabled()) {
                break;
            }
        }
        return (BackCallback) obj;
    }
}
