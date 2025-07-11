package ru.mrlargha.commonui.elements.craft.domain;

import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
/* compiled from: CraftResponse.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\"!\u0010\u0000\u001a\u0012\u0012\u0004\u0012\u00020\u00020\u0001j\b\u0012\u0004\u0012\u00020\u0002`\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0005\"!\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\u00020\u0001j\b\u0012\u0004\u0012\u00020\u0002`\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u0005¨\u0006\b"}, d2 = {"rodinaCraftCategories", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "getRodinaCraftCategories", "()Ljava/util/ArrayList;", "arizonaCraftCategories", "getArizonaCraftCategories", "CommonUI_release_web"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class CraftResponseKt {
    private static final ArrayList<String> rodinaCraftCategories = CollectionsKt.arrayListOf("Аксессуары", "Одежда", "Химия", "Обработка", "Теплица", "Тюнинг", "Чертежи", "Оружие", "Телефон", "Актеры", "Семена", "Транспорт", "Садоводство", "Актеры", "Аксессуары", "Одежда", "Обьекты для дома");
    private static final ArrayList<String> arizonaCraftCategories = CollectionsKt.arrayListOf("Аксессуары", "Одежда", "Химия", "Обработка", "Тюнинг", "Эликсиры");

    public static final ArrayList<String> getRodinaCraftCategories() {
        return rodinaCraftCategories;
    }

    public static final ArrayList<String> getArizonaCraftCategories() {
        return arizonaCraftCategories;
    }
}
