package ru.mrlargha.commonui.elements.azvoice;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import ru.mrlargha.commonui.R;
import ru.mrlargha.commonui.core.SAMPUIElement;
import ru.mrlargha.commonui.core.UIElementAbstractSpawner;
import ru.mrlargha.commonui.elements.azvoice.adapter.SliderVoiceAdapter;
/* compiled from: AzVoiceUserSettings.kt */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001:\u0001\u001dB\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0014\u0010\u0010\u001a\u00020\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013J\u000e\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u0014J\u0006\u0010\u0017\u001a\u00020\u0011J\u000e\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u0005J\u0018\u0010\u001a\u001a\u00020\u00112\u0006\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u0005H\u0002R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lru/mrlargha/commonui/elements/azvoice/AzVoiceUserSettings;", "Lru/mrlargha/commonui/core/SAMPUIElement;", "targetActivity", "Landroid/app/Activity;", "backendID", "", "<init>", "(Landroid/app/Activity;I)V", "formLayout", "Landroidx/constraintlayout/widget/ConstraintLayout;", "recycler", "Landroidx/recyclerview/widget/RecyclerView;", "closeButton", "Landroidx/appcompat/widget/AppCompatImageView;", "sliderAdapter", "Lru/mrlargha/commonui/elements/azvoice/adapter/SliderVoiceAdapter;", "setSliders", "", "newSliders", "", "Lru/mrlargha/commonui/elements/azvoice/SoundSliderData;", "addSlider", "newSlider", "clearSliders", "removeSliderByPlayerId", "id", "valueChanged", "sliderId", "newValue", "Spawner", "CommonUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class AzVoiceUserSettings extends SAMPUIElement {
    private final AppCompatImageView closeButton;
    private final ConstraintLayout formLayout;
    private final RecyclerView recycler;
    private final SliderVoiceAdapter sliderAdapter;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AzVoiceUserSettings(Activity targetActivity, final int i) {
        super(targetActivity, i);
        Intrinsics.checkNotNullParameter(targetActivity, "targetActivity");
        View inflate = targetActivity.getLayoutInflater().inflate(R.layout.az_voice_user_settings, (ViewGroup) null);
        Intrinsics.checkNotNull(inflate, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout");
        ConstraintLayout constraintLayout = (ConstraintLayout) inflate;
        this.formLayout = constraintLayout;
        View findViewById = constraintLayout.findViewById(R.id.users_sound_sliders_recycler);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(...)");
        RecyclerView recyclerView = (RecyclerView) findViewById;
        this.recycler = recyclerView;
        View findViewById2 = constraintLayout.findViewById(R.id.closeButton);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(...)");
        AppCompatImageView appCompatImageView = (AppCompatImageView) findViewById2;
        this.closeButton = appCompatImageView;
        SliderVoiceAdapter sliderVoiceAdapter = new SliderVoiceAdapter(new Function3() { // from class: ru.mrlargha.commonui.elements.azvoice.AzVoiceUserSettings$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                Unit sliderAdapter$lambda$0;
                sliderAdapter$lambda$0 = AzVoiceUserSettings.sliderAdapter$lambda$0(AzVoiceUserSettings.this, ((Integer) obj).intValue(), ((Integer) obj2).intValue(), ((Integer) obj3).intValue());
                return sliderAdapter$lambda$0;
            }
        });
        this.sliderAdapter = sliderVoiceAdapter;
        addViewToConstraintLayout(constraintLayout, -1, -1);
        recyclerView.setLayoutManager(new GridLayoutManager(targetActivity, 2));
        recyclerView.setAdapter(sliderVoiceAdapter);
        appCompatImageView.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.azvoice.AzVoiceUserSettings$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AzVoiceUserSettings._init_$lambda$1(AzVoiceUserSettings.this, i, view);
            }
        });
        setVisibility(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit sliderAdapter$lambda$0(AzVoiceUserSettings azVoiceUserSettings, int i, int i2, int i3) {
        azVoiceUserSettings.valueChanged(i, i3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$1(AzVoiceUserSettings azVoiceUserSettings, int i, View view) {
        azVoiceUserSettings.getNotifier().clickedWrapper(i, 1, -1);
        azVoiceUserSettings.setVisibility(false);
        azVoiceUserSettings.clearSliders();
    }

    public final void setSliders(List<SoundSliderData> newSliders) {
        Intrinsics.checkNotNullParameter(newSliders, "newSliders");
        this.sliderAdapter.submitList(newSliders);
        this.sliderAdapter.notifyDataSetChanged();
    }

    public final void addSlider(SoundSliderData newSlider) {
        Intrinsics.checkNotNullParameter(newSlider, "newSlider");
        SliderVoiceAdapter sliderVoiceAdapter = this.sliderAdapter;
        List<SoundSliderData> currentList = sliderVoiceAdapter.getCurrentList();
        Intrinsics.checkNotNullExpressionValue(currentList, "getCurrentList(...)");
        sliderVoiceAdapter.submitList(CollectionsKt.plus((Collection<? extends SoundSliderData>) currentList, newSlider));
        SliderVoiceAdapter sliderVoiceAdapter2 = this.sliderAdapter;
        sliderVoiceAdapter2.notifyItemInserted(sliderVoiceAdapter2.getCurrentList().size() - 1);
    }

    public final void clearSliders() {
        this.sliderAdapter.submitList(CollectionsKt.emptyList());
        this.sliderAdapter.notifyDataSetChanged();
    }

    public final void removeSliderByPlayerId(final int i) {
        List<SoundSliderData> currentList = this.sliderAdapter.getCurrentList();
        Intrinsics.checkNotNullExpressionValue(currentList, "getCurrentList(...)");
        final Function1 function1 = new Function1() { // from class: ru.mrlargha.commonui.elements.azvoice.AzVoiceUserSettings$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                boolean removeSliderByPlayerId$lambda$2;
                removeSliderByPlayerId$lambda$2 = AzVoiceUserSettings.removeSliderByPlayerId$lambda$2(i, (SoundSliderData) obj);
                return Boolean.valueOf(removeSliderByPlayerId$lambda$2);
            }
        };
        Boolean.valueOf(currentList.removeIf(new Predicate() { // from class: ru.mrlargha.commonui.elements.azvoice.AzVoiceUserSettings$$ExternalSyntheticLambda1
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                boolean removeSliderByPlayerId$lambda$3;
                removeSliderByPlayerId$lambda$3 = AzVoiceUserSettings.removeSliderByPlayerId$lambda$3(Function1.this, obj);
                return removeSliderByPlayerId$lambda$3;
            }
        }));
        this.sliderAdapter.submitList(currentList);
        this.sliderAdapter.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean removeSliderByPlayerId$lambda$2(int i, SoundSliderData soundSliderData) {
        return soundSliderData.getSliderUId() == i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean removeSliderByPlayerId$lambda$3(Function1 function1, Object obj) {
        return ((Boolean) function1.invoke(obj)).booleanValue();
    }

    private final void valueChanged(int i, int i2) {
        getNotifier().sliderValueChangedWrapper(getBackendID(), i, i2);
    }

    /* compiled from: AzVoiceUserSettings.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, d2 = {"Lru/mrlargha/commonui/elements/azvoice/AzVoiceUserSettings$Spawner;", "Lru/mrlargha/commonui/core/UIElementAbstractSpawner;", "<init>", "()V", "create", "Lru/mrlargha/commonui/core/SAMPUIElement;", "targetActivity", "Landroid/app/Activity;", "backendID", "", "CommonUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Spawner extends UIElementAbstractSpawner {
        @Override // ru.mrlargha.commonui.core.UIElementAbstractSpawner
        public SAMPUIElement create(Activity targetActivity, int i) {
            Intrinsics.checkNotNullParameter(targetActivity, "targetActivity");
            return new AzVoiceUserSettings(targetActivity, i);
        }
    }
}
