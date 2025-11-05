package ru.mrlargha.commonui.elements.items3d;

import kotlin.Metadata;
/* compiled from: Interface.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u0007\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&JH\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\bH&J \u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH&J\b\u0010\u0012\u001a\u00020\u0003H&J\u0018\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0015H&J(\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\u0015H&¨\u0006\u001aÀ\u0006\u0003"}, d2 = {"Lru/mrlargha/commonui/elements/items3d/ItemScene;", "", "setupScene", "", "setCarModel", "id", "", "isSimple", "", "bg", "", "mainColor", "secondColor", "bgPath", "wear", "isCar", "setCarModule", "module", "closeScene", "scaleModel", "scale", "", "rotateModel", "x", "y", "z", "CommonUI_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes6.dex */
public interface ItemScene {
    void closeScene();

    void rotateModel(int i, float f, float f2, float f3);

    void scaleModel(int i, float f);

    void setCarModel(int i, boolean z, String str, int i2, int i3, String str2, int i4, boolean z2);

    void setCarModule(int i, int i2, boolean z);

    void setupScene();
}
