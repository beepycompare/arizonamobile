package com.arkivanov.essenty.statekeeper.base64;

import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: Dictionaries.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0019\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\u0003\"\u0014\u0010\u0000\u001a\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003\"\u0014\u0010\u0004\u001a\u00020\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"dictionary", "", "getDictionary", "()[C", "backDictionary", "", "getBackDictionary", "()[I", "state-keeper_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class DictionariesKt {
    private static final int[] backDictionary;
    private static final char[] dictionary;

    static {
        char[] charArray = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".toCharArray();
        Intrinsics.checkNotNullExpressionValue(charArray, "toCharArray(...)");
        dictionary = charArray;
        int[] iArr = new int[128];
        for (int i = 0; i < 128; i++) {
            iArr[i] = ArraysKt.indexOf(dictionary, (char) i);
        }
        backDictionary = iArr;
    }

    public static final char[] getDictionary() {
        return dictionary;
    }

    public static final int[] getBackDictionary() {
        return backDictionary;
    }
}
