package com.google.gson.internal.bind;

import com.google.gson.TypeAdapter;
/* loaded from: classes4.dex */
public abstract class SerializationDelegatingTypeAdapter<T> extends TypeAdapter<T> {
    public abstract TypeAdapter<T> getSerializationDelegate();
}
