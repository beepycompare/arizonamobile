package ru.mrlargha.commonui.elements.hud.presentation.hud_screens.football;

import android.widget.FrameLayout;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import ru.mrlargha.commonui.databinding.HudFootballBinding;
import ru.mrlargha.commonui.utils.MapperKt;
/* compiled from: HudFootball.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rJ\u0016\u0010\u000e\u001a\u00020\u000b2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H\u0002J\b\u0010\u0012\u001a\u00020\u000bH\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lru/mrlargha/commonui/elements/hud/presentation/hud_screens/football/HudFootball;", "", "binding", "Lru/mrlargha/commonui/databinding/HudFootballBinding;", "<init>", "(Lru/mrlargha/commonui/databinding/HudFootballBinding;)V", "getBinding", "()Lru/mrlargha/commonui/databinding/HudFootballBinding;", "adapter", "Lru/mrlargha/commonui/elements/hud/presentation/hud_screens/football/HudFootballAdapter;", "event", "", "data", "", "show", "list", "", "Lru/mrlargha/commonui/elements/hud/presentation/hud_screens/football/HudFootballModel;", "hide", "CommonUI"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class HudFootball {
    private HudFootballAdapter adapter;
    private final HudFootballBinding binding;

    public HudFootball(HudFootballBinding binding) {
        Intrinsics.checkNotNullParameter(binding, "binding");
        this.binding = binding;
        this.adapter = new HudFootballAdapter();
        binding.rvCommands.setAdapter(this.adapter);
    }

    public final HudFootballBinding getBinding() {
        return this.binding;
    }

    private final void show(List<HudFootballModel> list) {
        FrameLayout root = this.binding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        root.setVisibility(0);
        this.adapter.submitList(list);
    }

    private final void hide() {
        FrameLayout root = this.binding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        root.setVisibility(8);
    }

    public final void event(String data) {
        ArrayList arrayList;
        Intrinsics.checkNotNullParameter(data, "data");
        try {
            if (MapperKt.isJsonValid(data)) {
                JsonArray asJsonArray = ((JsonElement) MapperKt.getGson().fromJson(data, (Class<Object>) JsonElement.class)).getAsJsonArray();
                Intrinsics.checkNotNull(asJsonArray);
                JsonArray<JsonElement> jsonArray = asJsonArray;
                ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(jsonArray, 10));
                for (JsonElement jsonElement : jsonArray) {
                    arrayList2.add(MapperKt.getGson().fromJson(jsonElement, (Class<Object>) HudFootballModel.class));
                }
                arrayList = arrayList2;
            } else {
                arrayList = CollectionsKt.emptyList();
            }
            show(arrayList);
        } catch (Exception unused) {
            hide();
        }
    }
}
