package ru.mrlargha.arizonaui.mobile.presentation.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import ru.mrlargha.arizonaui.R;
import ru.mrlargha.arizonaui.databinding.MessengerProfileColorItemBinding;
/* compiled from: MobilePhoneMessengerColorsAdapter.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001d\u0012\u0014\b\u0002\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0018\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0011H\u0016J\b\u0010\u0015\u001a\u00020\u0011H\u0016J\u0010\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0005H\u0002J\u000e\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0011J\u0014\u0010\u0018\u001a\u00020\u00062\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\u0019J\u0006\u0010\u001a\u001a\u00020\u0006R\u001d\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lru/mrlargha/arizonaui/mobile/presentation/adapter/MobilePhoneMessengerColorsAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lru/mrlargha/arizonaui/mobile/presentation/adapter/MobilePhoneMessengerColorViewHolder;", "onColorSelect", "Lkotlin/Function1;", "Lru/mrlargha/arizonaui/mobile/presentation/adapter/ColorItem;", "", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "getOnColorSelect", "()Lkotlin/jvm/functions/Function1;", "colors", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "holder", "position", "getItemCount", "selectColor", "selectedColor", "addData", "", "clearData", "ArizonaUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class MobilePhoneMessengerColorsAdapter extends RecyclerView.Adapter<MobilePhoneMessengerColorViewHolder> {
    private final List<ColorItem> colors;
    private final Function1<ColorItem, Unit> onColorSelect;

    public MobilePhoneMessengerColorsAdapter() {
        this(null, 1, null);
    }

    public /* synthetic */ MobilePhoneMessengerColorsAdapter(Function1 function1, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new Function1() { // from class: ru.mrlargha.arizonaui.mobile.presentation.adapter.MobilePhoneMessengerColorsAdapter$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit _init_$lambda$0;
                _init_$lambda$0 = MobilePhoneMessengerColorsAdapter._init_$lambda$0((ColorItem) obj);
                return _init_$lambda$0;
            }
        } : function1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit _init_$lambda$0(ColorItem it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    public final Function1<ColorItem, Unit> getOnColorSelect() {
        return this.onColorSelect;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public MobilePhoneMessengerColorsAdapter(Function1<? super ColorItem, Unit> onColorSelect) {
        Intrinsics.checkNotNullParameter(onColorSelect, "onColorSelect");
        this.onColorSelect = onColorSelect;
        this.colors = new ArrayList();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public MobilePhoneMessengerColorViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.messenger_profile_color_item, parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        return new MobilePhoneMessengerColorViewHolder(inflate);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(MobilePhoneMessengerColorViewHolder holder, int i) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        final ColorItem colorItem = this.colors.get(i);
        MessengerProfileColorItemBinding binding = holder.getBinding();
        binding.colorCv.setCardBackgroundColor(colorItem.getColor().getBackground());
        if (colorItem.isSelected()) {
            binding.getRoot().setBackground(ContextCompat.getDrawable(binding.getRoot().getContext(), R.drawable.border_selected_color));
        } else {
            binding.getRoot().setBackground(null);
        }
        holder.getBinding().getRoot().setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.arizonaui.mobile.presentation.adapter.MobilePhoneMessengerColorsAdapter$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MobilePhoneMessengerColorsAdapter.onBindViewHolder$lambda$2(MobilePhoneMessengerColorsAdapter.this, colorItem, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onBindViewHolder$lambda$2(MobilePhoneMessengerColorsAdapter mobilePhoneMessengerColorsAdapter, ColorItem colorItem, View view) {
        mobilePhoneMessengerColorsAdapter.selectColor(colorItem);
        mobilePhoneMessengerColorsAdapter.onColorSelect.invoke(colorItem);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.colors.size();
    }

    private final void selectColor(ColorItem colorItem) {
        List<ColorItem> list = this.colors;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        for (ColorItem colorItem2 : list) {
            arrayList.add(ColorItem.copy$default(colorItem2, null, false, 3, null));
        }
        this.colors.clear();
        List<ColorItem> list2 = this.colors;
        ArrayList<ColorItem> arrayList2 = arrayList;
        ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList2, 10));
        for (ColorItem colorItem3 : arrayList2) {
            arrayList3.add(ColorItem.copy$default(colorItem3, null, colorItem3.getColor() == colorItem.getColor(), 1, null));
        }
        list2.addAll(arrayList3);
        notifyDataSetChanged();
    }

    public final void selectColor(int i) {
        List<ColorItem> list = this.colors;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        for (ColorItem colorItem : list) {
            arrayList.add(ColorItem.copy$default(colorItem, null, false, 3, null));
        }
        this.colors.clear();
        List<ColorItem> list2 = this.colors;
        ArrayList arrayList2 = arrayList;
        ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList2, 10));
        int i2 = 0;
        for (Object obj : arrayList2) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            arrayList3.add(ColorItem.copy$default((ColorItem) obj, null, i2 == i, 1, null));
            i2 = i3;
        }
        list2.addAll(arrayList3);
        notifyDataSetChanged();
    }

    public final void addData(List<ColorItem> colors) {
        Intrinsics.checkNotNullParameter(colors, "colors");
        this.colors.addAll(colors);
        notifyDataSetChanged();
    }

    public final void clearData() {
        this.colors.clear();
        notifyDataSetChanged();
    }
}
