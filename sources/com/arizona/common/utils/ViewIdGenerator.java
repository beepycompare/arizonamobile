package com.arizona.common.utils;

import android.view.View;
import kotlin.Metadata;
/* compiled from: ViewIdGenerator.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0004\u001a\u00020\u0005H\u0007b\u0010\b\u0006\u0012\f\b\u0007\u0012\b\b\fJ\u0004\b\b(\b¨\u0006\t"}, d2 = {"Lcom/arizona/common/utils/ViewIdGenerator;", "", "<init>", "()V", "generateViewId", "", "Landroid/annotation/SuppressLint;", "value", "NewApi", "CommonLibs"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class ViewIdGenerator {
    public static final ViewIdGenerator INSTANCE = new ViewIdGenerator();

    private ViewIdGenerator() {
    }

    public final int generateViewId() {
        return View.generateViewId();
    }
}
