package ru.mrlargha.arizonaui.biz;

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
import ru.mrlargha.arizonaui.biz.MyBusinessScreen;
import ru.mrlargha.arizonaui.databinding.MyBusinessChildMenuItemBinding;
/* compiled from: MyBusinessChildMenuAdapter.kt */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0019\u001aB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\nJ\u0018\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0018\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0011H\u0016J\b\u0010\u0015\u001a\u00020\u0011H\u0016J\u0014\u0010\u0016\u001a\u00020\f2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00070\u0018R\u001e\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lru/mrlargha/arizonaui/biz/MyBusinessChildMenuAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lru/mrlargha/arizonaui/biz/MyBusinessChildMenuAdapter$BusinessViewHolder;", "<init>", "()V", "subMenuItemList", "Ljava/util/ArrayList;", "Lru/mrlargha/arizonaui/biz/MyBusinessScreen$Companion$SubMenuItem;", "Lkotlin/collections/ArrayList;", "onChildItemClickListener", "Lru/mrlargha/arizonaui/biz/MyBusinessChildMenuAdapter$OnChildItemClickListener;", "setOnChildItemClickListener", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "holder", "position", "getItemCount", "addChildMenu", "info", "", "OnChildItemClickListener", "BusinessViewHolder", "ArizonaUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class MyBusinessChildMenuAdapter extends RecyclerView.Adapter<BusinessViewHolder> {
    private OnChildItemClickListener onChildItemClickListener;
    private final ArrayList<MyBusinessScreen.Companion.SubMenuItem> subMenuItemList = new ArrayList<>();

    /* compiled from: MyBusinessChildMenuAdapter.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006À\u0006\u0003"}, d2 = {"Lru/mrlargha/arizonaui/biz/MyBusinessChildMenuAdapter$OnChildItemClickListener;", "", "callback", "", "id", "", "ArizonaUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public interface OnChildItemClickListener {
        void callback(int i);
    }

    public final void setOnChildItemClickListener(OnChildItemClickListener onChildItemClickListener) {
        Intrinsics.checkNotNullParameter(onChildItemClickListener, "onChildItemClickListener");
        this.onChildItemClickListener = onChildItemClickListener;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public BusinessViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.my_business_child_menu_item, parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        return new BusinessViewHolder(inflate);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(BusinessViewHolder holder, int i) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        MyBusinessScreen.Companion.SubMenuItem subMenuItem = this.subMenuItemList.get(i);
        Intrinsics.checkNotNullExpressionValue(subMenuItem, "get(...)");
        final MyBusinessScreen.Companion.SubMenuItem subMenuItem2 = subMenuItem;
        MyBusinessChildMenuItemBinding binding = holder.getBinding();
        binding.title.setText(subMenuItem2.getTitle());
        EasyAnimation easyAnimation = EasyAnimation.INSTANCE;
        ConstraintLayout myBusinessChildMenuItem = binding.myBusinessChildMenuItem;
        Intrinsics.checkNotNullExpressionValue(myBusinessChildMenuItem, "myBusinessChildMenuItem");
        EasyAnimation.animateClick$default(easyAnimation, myBusinessChildMenuItem, 0L, null, new Function0() { // from class: ru.mrlargha.arizonaui.biz.MyBusinessChildMenuAdapter$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit onBindViewHolder$lambda$2$lambda$1;
                onBindViewHolder$lambda$2$lambda$1 = MyBusinessChildMenuAdapter.onBindViewHolder$lambda$2$lambda$1(MyBusinessChildMenuAdapter.this, subMenuItem2);
                return onBindViewHolder$lambda$2$lambda$1;
            }
        }, 3, null);
        if (subMenuItem2.isPressed()) {
            binding.title.setTextColor(Color.parseColor("#FFFFFF"));
        } else {
            binding.title.setTextColor(Color.parseColor("#999999"));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onBindViewHolder$lambda$2$lambda$1(MyBusinessChildMenuAdapter myBusinessChildMenuAdapter, MyBusinessScreen.Companion.SubMenuItem subMenuItem) {
        OnChildItemClickListener onChildItemClickListener = myBusinessChildMenuAdapter.onChildItemClickListener;
        if (onChildItemClickListener == null) {
            Intrinsics.throwUninitializedPropertyAccessException("onChildItemClickListener");
            onChildItemClickListener = null;
        }
        onChildItemClickListener.callback(subMenuItem.getId());
        subMenuItem.setPressed(!subMenuItem.isPressed());
        for (MyBusinessScreen.Companion.SubMenuItem subMenuItem2 : myBusinessChildMenuAdapter.subMenuItemList) {
            if (subMenuItem2.getId() != subMenuItem.getId()) {
                subMenuItem2.setPressed(false);
            }
        }
        myBusinessChildMenuAdapter.notifyDataSetChanged();
        return Unit.INSTANCE;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.subMenuItemList.size();
    }

    /* compiled from: MyBusinessChildMenuAdapter.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lru/mrlargha/arizonaui/biz/MyBusinessChildMenuAdapter$BusinessViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "binding", "Lru/mrlargha/arizonaui/databinding/MyBusinessChildMenuItemBinding;", "getBinding", "()Lru/mrlargha/arizonaui/databinding/MyBusinessChildMenuItemBinding;", "ArizonaUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class BusinessViewHolder extends RecyclerView.ViewHolder {
        private final MyBusinessChildMenuItemBinding binding;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public BusinessViewHolder(View view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "view");
            MyBusinessChildMenuItemBinding bind = MyBusinessChildMenuItemBinding.bind(view);
            Intrinsics.checkNotNullExpressionValue(bind, "bind(...)");
            this.binding = bind;
        }

        public final MyBusinessChildMenuItemBinding getBinding() {
            return this.binding;
        }
    }

    public final void addChildMenu(List<MyBusinessScreen.Companion.SubMenuItem> info) {
        Intrinsics.checkNotNullParameter(info, "info");
        this.subMenuItemList.clear();
        this.subMenuItemList.addAll(info);
        notifyDataSetChanged();
    }
}
