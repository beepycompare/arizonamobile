package ru.mrlargha.arizonaui.house;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.arizona.common.utils.EasyAnimation;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import ru.mrlargha.arizonaui.R;
import ru.mrlargha.arizonaui.databinding.MyHouseMenuItemBinding;
import ru.mrlargha.arizonaui.house.MyHouseChildMenuAdapter;
import ru.mrlargha.arizonaui.house.MyHouseMenuAdapter;
import ru.mrlargha.arizonaui.house.MyHouseScreen;
/* compiled from: MyHouseMenuAdapter.kt */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u001a\u001bB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\nJ\u0018\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0018\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0011H\u0016J\b\u0010\u0015\u001a\u00020\u0011H\u0016J\u0014\u0010\u0016\u001a\u00020\f2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00070\u0018J\u0006\u0010\u0019\u001a\u00020\fR\u001e\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lru/mrlargha/arizonaui/house/MyHouseMenuAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lru/mrlargha/arizonaui/house/MyHouseMenuAdapter$ViewHolder;", "<init>", "()V", "menuItemList", "Ljava/util/ArrayList;", "Lru/mrlargha/arizonaui/house/MyHouseScreen$Companion$MenuItem;", "Lkotlin/collections/ArrayList;", "onParentItemClickListener", "Lru/mrlargha/arizonaui/house/MyHouseMenuAdapter$OnParentItemClickListener;", "setOnParentItemClickListener", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "holder", "position", "getItemCount", "addMenu", "info", "", "clearMenu", "OnParentItemClickListener", "ViewHolder", "ArizonaUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class MyHouseMenuAdapter extends RecyclerView.Adapter<ViewHolder> {
    private final ArrayList<MyHouseScreen.Companion.MenuItem> menuItemList = new ArrayList<>();
    private OnParentItemClickListener onParentItemClickListener;

    /* compiled from: MyHouseMenuAdapter.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lru/mrlargha/arizonaui/house/MyHouseMenuAdapter$OnParentItemClickListener;", "", "callback", "", "id", "", "ArizonaUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public interface OnParentItemClickListener {
        void callback(int i);
    }

    public final void setOnParentItemClickListener(OnParentItemClickListener onParentItemClickListener) {
        Intrinsics.checkNotNullParameter(onParentItemClickListener, "onParentItemClickListener");
        this.onParentItemClickListener = onParentItemClickListener;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public ViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.my_house_menu_item, parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        return new ViewHolder(inflate);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(ViewHolder holder, int i) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        MyHouseScreen.Companion.MenuItem menuItem = this.menuItemList.get(i);
        Intrinsics.checkNotNullExpressionValue(menuItem, "get(...)");
        final MyHouseScreen.Companion.MenuItem menuItem2 = menuItem;
        MyHouseMenuItemBinding binding = holder.getBinding();
        binding.title.setText(menuItem2.getTitle());
        EasyAnimation easyAnimation = EasyAnimation.INSTANCE;
        ConstraintLayout menuItem3 = binding.menuItem;
        Intrinsics.checkNotNullExpressionValue(menuItem3, "menuItem");
        EasyAnimation.animateClick$default(easyAnimation, menuItem3, 0L, null, new Function0() { // from class: ru.mrlargha.arizonaui.house.MyHouseMenuAdapter$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit onBindViewHolder$lambda$4$lambda$3;
                onBindViewHolder$lambda$4$lambda$3 = MyHouseMenuAdapter.onBindViewHolder$lambda$4$lambda$3(MyHouseScreen.Companion.MenuItem.this, this);
                return onBindViewHolder$lambda$4$lambda$3;
            }
        }, 3, null);
        MyHouseChildMenuAdapter myHouseChildMenuAdapter = new MyHouseChildMenuAdapter();
        binding.childMenuRc.setAdapter(myHouseChildMenuAdapter);
        myHouseChildMenuAdapter.addChildMenu(menuItem2.getItems());
        myHouseChildMenuAdapter.setOnChildItemClickListener(new MyHouseChildMenuAdapter.OnChildItemClickListener() { // from class: ru.mrlargha.arizonaui.house.MyHouseMenuAdapter$onBindViewHolder$1$2
            @Override // ru.mrlargha.arizonaui.house.MyHouseChildMenuAdapter.OnChildItemClickListener
            public void callback(int i2) {
                MyHouseMenuAdapter.OnParentItemClickListener onParentItemClickListener;
                onParentItemClickListener = MyHouseMenuAdapter.this.onParentItemClickListener;
                if (onParentItemClickListener == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("onParentItemClickListener");
                    onParentItemClickListener = null;
                }
                onParentItemClickListener.callback(i2);
            }
        });
        if (menuItem2.isPressed()) {
            binding.title.setTextColor(Color.parseColor("#FFFFFF"));
            binding.childMenuRc.setVisibility(0);
            binding.arrow.setRotation(0.0f);
            binding.arrow.setColorFilter(Color.parseColor("#FFFFFF"));
            return;
        }
        binding.title.setTextColor(Color.parseColor("#999999"));
        binding.arrow.setRotation(180.0f);
        binding.arrow.setColorFilter(Color.parseColor("#999999"));
        binding.childMenuRc.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onBindViewHolder$lambda$4$lambda$3(MyHouseScreen.Companion.MenuItem menuItem, MyHouseMenuAdapter myHouseMenuAdapter) {
        menuItem.setPressed(!menuItem.isPressed());
        for (MyHouseScreen.Companion.MenuItem menuItem2 : myHouseMenuAdapter.menuItemList) {
            if (menuItem2.getId() != menuItem.getId()) {
                menuItem2.setPressed(false);
                for (MyHouseScreen.Companion.SubMenuItem subMenuItem : menuItem2.getItems()) {
                    subMenuItem.setPressed(false);
                }
            }
        }
        if (!menuItem.isPressed()) {
            for (MyHouseScreen.Companion.SubMenuItem subMenuItem2 : menuItem.getItems()) {
                subMenuItem2.setPressed(false);
            }
        }
        myHouseMenuAdapter.notifyDataSetChanged();
        return Unit.INSTANCE;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.menuItemList.size();
    }

    /* compiled from: MyHouseMenuAdapter.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lru/mrlargha/arizonaui/house/MyHouseMenuAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "binding", "Lru/mrlargha/arizonaui/databinding/MyHouseMenuItemBinding;", "getBinding", "()Lru/mrlargha/arizonaui/databinding/MyHouseMenuItemBinding;", "ArizonaUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class ViewHolder extends RecyclerView.ViewHolder {
        private final MyHouseMenuItemBinding binding;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(View view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "view");
            MyHouseMenuItemBinding bind = MyHouseMenuItemBinding.bind(view);
            Intrinsics.checkNotNullExpressionValue(bind, "bind(...)");
            this.binding = bind;
        }

        public final MyHouseMenuItemBinding getBinding() {
            return this.binding;
        }
    }

    public final void addMenu(List<MyHouseScreen.Companion.MenuItem> info) {
        Intrinsics.checkNotNullParameter(info, "info");
        this.menuItemList.addAll(info);
        notifyDataSetChanged();
    }

    public final void clearMenu() {
        this.menuItemList.clear();
    }
}
