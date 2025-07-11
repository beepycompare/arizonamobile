package ru.mrlargha.arizonaui.family.adapters;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import ru.mrlargha.arizonaui.R;
import ru.mrlargha.arizonaui.databinding.FamilyCharterItemBinding;
import ru.mrlargha.arizonaui.family.data.FamilyCharterData;
/* compiled from: CharterAdapter.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001b\u0012\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0005H\u0016J\u0018\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u0005H\u0016J\u000e\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\nJ\b\u0010\u001c\u001a\u00020\u0005H\u0016R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R \u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lru/mrlargha/arizonaui/family/adapters/CharterAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lru/mrlargha/arizonaui/family/adapters/CharterItemViewHolder;", "onClick", "Lkotlin/Function1;", "", "", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "data", "Lru/mrlargha/arizonaui/family/data/FamilyCharterData;", FirebaseAnalytics.Param.ITEMS, "", "getItems", "()Ljava/util/List;", "setItems", "(Ljava/util/List;)V", "estateColor", "descColor", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "holder", "position", "setInfo", "info", "getItemCount", "ArizonaUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class CharterAdapter extends RecyclerView.Adapter<CharterItemViewHolder> {
    private FamilyCharterData data;
    private final int descColor;
    private final int estateColor;
    private List<Integer> items;
    private final Function1<Integer, Unit> onClick;

    /* JADX WARN: Multi-variable type inference failed */
    public CharterAdapter(Function1<? super Integer, Unit> onClick) {
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        this.onClick = onClick;
        this.data = new FamilyCharterData("", "", 0, 0, 0, 0, 0);
        this.items = CollectionsKt.toMutableList(new IntRange(0, 9));
        this.estateColor = Color.parseColor("#E0CA4C");
        this.descColor = Color.parseColor("#ABABAB");
    }

    public final List<Integer> getItems() {
        return this.items;
    }

    public final void setItems(List<Integer> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.items = list;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public CharterItemViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.family_charter_item, parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        return new CharterItemViewHolder(inflate);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(CharterItemViewHolder holder, int i) {
        int i2;
        String str;
        int i3;
        int i4;
        String str2;
        Intrinsics.checkNotNullParameter(holder, "holder");
        Integer num = (Integer) CollectionsKt.getOrNull(this.items, i);
        if (num != null) {
            final int intValue = num.intValue();
            FamilyCharterItemBinding binding = holder.getBinding();
            String str3 = "???";
            if (intValue <= 3) {
                binding.card1.setVisibility(8);
                binding.card2.setVisibility(0);
                if (intValue == 0) {
                    i3 = R.drawable.family_charter_ic_leader;
                } else if (intValue == 1) {
                    i3 = R.drawable.family_charter_ic_name;
                } else if (intValue == 2) {
                    i3 = R.drawable.family_charter_ic_tax;
                } else if (intValue == 3) {
                    i3 = R.drawable.family_charter_ic_revenue;
                } else {
                    i3 = R.drawable.family_menu_ic_info;
                }
                if (intValue == 0) {
                    i4 = R.drawable.family_charter_ic_leader1;
                } else if (intValue == 1) {
                    i4 = R.drawable.family_charter_ic_name1;
                } else if (intValue == 2) {
                    i4 = R.drawable.family_charter_ic_tax1;
                } else if (intValue == 3) {
                    i4 = R.drawable.family_charter_ic_revenue1;
                } else {
                    i4 = R.drawable.family_estate_ic_adi_kit;
                }
                if (intValue == 0) {
                    str2 = "Текущий лидер организации";
                } else if (intValue == 1) {
                    str2 = "Название частной организации";
                } else if (intValue == 2) {
                    str2 = "Текущая сумма налога";
                } else if (intValue != 3) {
                    str2 = "???";
                } else {
                    str2 = "Прибыль за месяц";
                }
                if (intValue != 2) {
                    if (intValue == 3) {
                        binding.item2Desc.setTextColor(Color.parseColor("#C1FF3D"));
                    } else {
                        binding.item2Desc.setTextColor(-1);
                    }
                } else if (this.data.getTaxCurrent() >= 4500000) {
                    binding.item2Desc.setTextColor(Color.parseColor("#FE5B3B"));
                } else {
                    binding.item2Desc.setTextColor(-1);
                }
                if (intValue == 0) {
                    str3 = String.valueOf(this.data.getLeader());
                } else if (intValue == 1) {
                    str3 = this.data.getName();
                } else if (intValue == 2) {
                    str3 = this.data.getTaxCurrent() + " / " + this.data.getTaxTotal() + " $";
                } else if (intValue == 3) {
                    str3 = "+ " + this.data.getIncomeMonth() + " $";
                }
                binding.level2Image.setImageResource(i3);
                binding.level2ImageBg.setImageResource(i4);
                binding.item2Title.setText(str2);
                binding.item2Desc.setText(str3);
            } else {
                binding.card2.setVisibility(8);
                binding.card1.setVisibility(0);
                switch (intValue) {
                    case 4:
                        i2 = R.drawable.family_menu_ic_members;
                        break;
                    case 5:
                        i2 = R.drawable.family_settins_ic_leader;
                        break;
                    case 6:
                        i2 = R.drawable.family_charter_ic_bank;
                        break;
                    case 7:
                        i2 = R.drawable.family_settins_ic_location;
                        break;
                    case 8:
                        i2 = R.drawable.family_charter_ic_gov;
                        break;
                    case 9:
                        i2 = R.drawable.family_charter_ic_trade;
                        break;
                    default:
                        i2 = R.drawable.family_menu_ic_info;
                        break;
                }
                switch (intValue) {
                    case 4:
                        str = "Список участников";
                        break;
                    case 5:
                        str = "Управление лидером";
                        break;
                    case 6:
                        str = "Лог банговских операций";
                        break;
                    case 7:
                        str = "Найти частную организацию";
                        break;
                    case 8:
                        str = "Продать государству";
                        break;
                    case 9:
                        str = "Продать другой семье";
                        break;
                    default:
                        str = "???";
                        break;
                }
                switch (intValue) {
                    case 4:
                        str3 = "Список всех членов частной организации";
                        break;
                    case 5:
                        str3 = "Назначить / снять лидера и его статистика";
                        break;
                    case 6:
                        str3 = "История банковских операций организации";
                        break;
                    case 7:
                        str3 = "Отметить организацию в GPS";
                        break;
                    case 8:
                        str3 = "Продать частную организацию государству";
                        break;
                    case 9:
                        str3 = "Продать частную организацию другой семье";
                        break;
                }
                int parseColor = Color.parseColor("#0DFFFFFF");
                binding.levelImage.setImageResource(i2);
                binding.itemTitle.setText(str);
                binding.itemDesc.setText(str3);
                binding.card1.setCardBackgroundColor(parseColor);
            }
            binding.getRoot().setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.arizonaui.family.adapters.CharterAdapter$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    CharterAdapter.onBindViewHolder$lambda$1$lambda$0(CharterAdapter.this, intValue, view);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onBindViewHolder$lambda$1$lambda$0(CharterAdapter charterAdapter, int i, View view) {
        charterAdapter.onClick.invoke(Integer.valueOf(i));
    }

    public final void setInfo(FamilyCharterData info) {
        Intrinsics.checkNotNullParameter(info, "info");
        this.data = info;
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.items.size();
    }
}
