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
import ru.mrlargha.arizonaui.databinding.FamilyMenuItemBinding;
/* compiled from: MainMenuAdapter.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001b\u0012\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0005H\u0016J\u0018\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0005H\u0016J\b\u0010\u0019\u001a\u00020\u0005H\u0016J\u000e\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u0005J\u0014\u0010\u001c\u001a\u00020\u00062\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00050\u000bR\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R \u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lru/mrlargha/arizonaui/family/adapters/MainMenuAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lru/mrlargha/arizonaui/family/adapters/MenuItemViewHolder;", "onClick", "Lkotlin/Function1;", "", "", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "onlineCount", FirebaseAnalytics.Param.ITEMS, "", "getItems", "()Ljava/util/List;", "setItems", "(Ljava/util/List;)V", "estateColor", "descColor", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "holder", "position", "getItemCount", "setOnline", "int", "setMenuItems", "info", "ArizonaUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class MainMenuAdapter extends RecyclerView.Adapter<MenuItemViewHolder> {
    private final int descColor;
    private final int estateColor;
    private List<Integer> items;
    private final Function1<Integer, Unit> onClick;
    private int onlineCount;

    /* JADX WARN: Multi-variable type inference failed */
    public MainMenuAdapter(Function1<? super Integer, Unit> onClick) {
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        this.onClick = onClick;
        this.onlineCount = 40;
        this.items = CollectionsKt.toList(new IntRange(0, 9));
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
    public MenuItemViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.family_menu_item, parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        return new MenuItemViewHolder(inflate);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(MenuItemViewHolder holder, int i) {
        int i2;
        String str;
        Intrinsics.checkNotNullParameter(holder, "holder");
        final Integer num = (Integer) CollectionsKt.getOrNull(this.items, i);
        FamilyMenuItemBinding binding = holder.getBinding();
        if (num == null) {
            binding.getRoot().setVisibility(8);
            return;
        }
        binding.getRoot().setVisibility(0);
        if (num.intValue() == 0) {
            i2 = R.drawable.family_menu_ic_home;
        } else if (num.intValue() == 1) {
            i2 = R.drawable.family_menu_ic_members;
        } else if (num.intValue() == 2) {
            i2 = R.drawable.family_menu_ic_wars;
        } else if (num.intValue() == 3) {
            i2 = R.drawable.family_menu_ic_shop;
        } else if (num.intValue() == 4) {
            i2 = R.drawable.family_menu_ic_settings;
        } else if (num.intValue() == 5) {
            i2 = R.drawable.family_menu_ic_apart;
        } else if (num.intValue() == 6) {
            i2 = R.drawable.family_menu_ic_estate;
        } else if (num.intValue() == 7) {
            i2 = R.drawable.family_menu_ic_charter;
        } else if (num.intValue() == 8) {
            i2 = R.drawable.family_menu_ic_info;
        } else {
            i2 = num.intValue() == 9 ? R.drawable.family_menu_ic_leave : R.drawable.family_menu_ic_info;
        }
        String str2 = "???";
        if (num.intValue() == 0) {
            str = "Главный раздел";
        } else if (num.intValue() == 1) {
            str = "Участники";
        } else if (num.intValue() == 2) {
            str = "Войны за территории";
        } else if (num.intValue() == 3) {
            str = "Семейный магазин";
        } else if (num.intValue() == 4) {
            str = "Управление семьей";
        } else if (num.intValue() == 5) {
            str = "Семейная квартира";
        } else if (num.intValue() == 6) {
            str = "Семейное поместье";
        } else if (num.intValue() == 7) {
            str = "Частная фракция";
        } else if (num.intValue() == 8) {
            str = "Доп. информация";
        } else {
            str = num.intValue() == 9 ? "Покинуть" : "???";
        }
        if (num.intValue() == 0) {
            str2 = "Информация о вашей\nсемье";
        } else if (num.intValue() == 1) {
            str2 = "Члены вашей семьи";
        } else if (num.intValue() == 2) {
            str2 = "Список встреч и информация о ваших территориях";
        } else if (num.intValue() == 3) {
            str2 = "Магазин аксессуаров за семейные монеты";
        } else if (num.intValue() == 4) {
            str2 = "Общие элементы управления и настроек";
        } else if (num.intValue() == 5) {
            str2 = "Информация о квартире и улучшениях";
        } else if (num.intValue() == 6) {
            str2 = "Информация о поместье и улучшениях";
        } else if (num.intValue() == 7) {
            str2 = "Управление частной фракцией";
        } else if (num.intValue() == 8) {
            str2 = "Улучшения, бонусы, список команд, ограничения заместителей";
        } else if (num.intValue() == 9) {
            str2 = "Покинуть состав семьи";
        }
        int parseColor = num.intValue() == 6 ? Color.parseColor("#1AE1AA33") : Color.parseColor("#0DFFFFFF");
        if (num.intValue() == 6) {
            binding.stroke.setVisibility(0);
            binding.itemTitle.setTextColor(this.estateColor);
            binding.itemDesc.setTextColor(this.estateColor);
        } else {
            binding.stroke.setVisibility(8);
            binding.itemTitle.setTextColor(-1);
            binding.itemDesc.setTextColor(this.descColor);
        }
        if (num.intValue() == 1) {
            binding.online.setText("В сети: " + this.onlineCount + " чел.");
            binding.onlineContainer.setVisibility(0);
        } else {
            binding.onlineContainer.setVisibility(8);
        }
        binding.levelImage.setImageResource(i2);
        binding.itemTitle.setText(str);
        binding.itemDesc.setText(str2);
        binding.card.setCardBackgroundColor(parseColor);
        binding.getRoot().setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.arizonaui.family.adapters.MainMenuAdapter$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MainMenuAdapter.onBindViewHolder$lambda$1$lambda$0(MainMenuAdapter.this, num, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onBindViewHolder$lambda$1$lambda$0(MainMenuAdapter mainMenuAdapter, Integer num, View view) {
        mainMenuAdapter.onClick.invoke(num);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.items.size();
    }

    public final void setOnline(int i) {
        this.onlineCount = i;
        notifyDataSetChanged();
    }

    public final void setMenuItems(List<Integer> info) {
        Intrinsics.checkNotNullParameter(info, "info");
        this.items = info;
    }
}
