package ru.mrlargha.commonui.elements.items3d;

import kotlin.Metadata;
/* compiled from: Interface.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0018\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH&J\u0018\u0010\t\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0006H&J\b\u0010\u000b\u001a\u00020\u0003H&J\u0018\u0010\f\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u000eH&J(\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u000eH&¨\u0006\u0013À\u0006\u0003"}, d2 = {"Lru/mrlargha/commonui/elements/items3d/ItemScene;", "", "setupScene", "", "setCarModel", "id", "", "bg", "", "setCarModule", "module", "closeScene", "scaleModel", "scale", "", "rotateModel", "x", "y", "z", "CommonUI_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes6.dex */
public interface ItemScene {
    void closeScene();

    void rotateModel(int i, float f, float f2, float f3);

    void scaleModel(int i, float f);

    void setCarModel(int i, String str);

    void setCarModule(int i, int i2);

    void setupScene();
}
