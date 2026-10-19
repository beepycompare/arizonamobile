package ru.mrlargha.commonui.elements.settingsMenu;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.appcompat.widget.SwitchCompat;
import androidx.recyclerview.widget.RecyclerView;
import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import com.google.android.material.slider.Slider;
import io.appmetrica.analytics.networktasks.internal.CommonUrlParts;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt;
import ru.mrlargha.commonui.R;
import ru.mrlargha.commonui.databinding.SettingItemBinding;
import ru.mrlargha.commonui.elements.settingsMenu.model.SettingItemModel;
import ru.mrlargha.commonui.elements.settingsMenu.model.SettingType;
/* compiled from: SettingsAdapter.kt */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001By\u0012M\b\u0002\u0010\u0003\u001aG\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f0\u0004\u0012!\u0010\r\u001a\u001d\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\f0\u000e¢\u0006\u0004\b\u0010\u0010\u0011J\u0018\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0005H\u0016J\u0018\u0010\u001d\u001a\u00020\f2\u0006\u0010\u001e\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0005H\u0016J\u0018\u0010\u001f\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010 \u001a\u00020!H\u0002J\u0018\u0010\"\u001a\u00020\f2\u0006\u0010\u001e\u001a\u00020\u00022\u0006\u0010 \u001a\u00020#H\u0002J\u0018\u0010$\u001a\u00020\f2\u0006\u0010\u001e\u001a\u00020\u00022\u0006\u0010 \u001a\u00020%H\u0002J\u0018\u0010&\u001a\u00020\f2\u0006\u0010\u001e\u001a\u00020\u00022\u0006\u0010 \u001a\u00020'H\u0002J\u0018\u0010(\u001a\u00020\f2\u0006\u0010\u001e\u001a\u00020\u00022\u0006\u0010 \u001a\u00020)H\u0002J\u0018\u0010*\u001a\u00020\f2\u0006\u0010\u001e\u001a\u00020\u00022\u0006\u0010 \u001a\u00020+H\u0002J\u0018\u0010,\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010-\u001a\u00020\u0005H\u0002J\u0010\u0010.\u001a\u00020\f2\u0006\u0010\u001e\u001a\u00020\u0002H\u0002J\b\u0010/\u001a\u00020\u0005H\u0016J\u0006\u00100\u001a\u00020\fJ\u001c\u00101\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\u00052\f\u00102\u001a\b\u0012\u0004\u0012\u00020\n03RV\u0010\u0003\u001aG\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f0\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R,\u0010\r\u001a\u001d\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\f0\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u001e\u0010\u0016\u001a\u0012\u0012\u0004\u0012\u00020\n0\u0017j\b\u0012\u0004\u0012\u00020\n`\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00064"}, d2 = {"Lru/mrlargha/commonui/elements/settingsMenu/SettingsAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lru/mrlargha/commonui/elements/settingsMenu/SettingItemViewHolder;", "onUpdateSettings", "Lkotlin/Function3;", "", "Lkotlin/ParameterName;", "name", "settingType", "position", "Lru/mrlargha/commonui/elements/settingsMenu/model/SettingItemModel;", CommonUrlParts.MODEL, "", "onClickLink", "Lkotlin/Function1;", "linkId", "<init>", "(Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function1;)V", "getOnUpdateSettings", "()Lkotlin/jvm/functions/Function3;", "getOnClickLink", "()Lkotlin/jvm/functions/Function1;", "settingItems", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "holder", "updateSettings", ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, "Lru/mrlargha/commonui/elements/settingsMenu/model/SettingType;", "setupSwitcherUi", "Lru/mrlargha/commonui/elements/settingsMenu/model/SettingType$SettingSwitcher;", "setupLinkUi", "Lru/mrlargha/commonui/elements/settingsMenu/model/SettingType$SettingLink;", "setupTextSwitcherUi", "Lru/mrlargha/commonui/elements/settingsMenu/model/SettingType$SettingTextSwitcher;", "setupSliderUi", "Lru/mrlargha/commonui/elements/settingsMenu/model/SettingType$SettingSlider;", "setupSelectorsUi", "Lru/mrlargha/commonui/elements/settingsMenu/model/SettingType$SettingSelector;", "savedSelectInList", "selectIndex", "unselectOtherSelectors", "getItemCount", "clear", "setSettings", "settings", "", "CommonUI"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class SettingsAdapter extends RecyclerView.Adapter<SettingItemViewHolder> {
    private final Function1<Integer, Unit> onClickLink;
    private final Function3<Integer, Integer, SettingItemModel, Unit> onUpdateSettings;
    private final ArrayList<SettingItemModel> settingItems;
    private int settingType;

    /* JADX WARN: Multi-variable type inference failed */
    public SettingsAdapter(Function3<? super Integer, ? super Integer, ? super SettingItemModel, Unit> onUpdateSettings, Function1<? super Integer, Unit> onClickLink) {
        Intrinsics.checkNotNullParameter(onUpdateSettings, "onUpdateSettings");
        Intrinsics.checkNotNullParameter(onClickLink, "onClickLink");
        this.onUpdateSettings = onUpdateSettings;
        this.onClickLink = onClickLink;
        this.settingItems = new ArrayList<>();
        this.settingType = R.id.main_page_button;
    }

    public /* synthetic */ SettingsAdapter(Function3 function3, Function1 function1, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new Function3() { // from class: ru.mrlargha.commonui.elements.settingsMenu.SettingsAdapter$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return SettingsAdapter._init_$lambda$0(((Integer) obj).intValue(), ((Integer) obj2).intValue(), (SettingItemModel) obj3);
            }
        } : function3, function1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit _init_$lambda$0(int i, int i2, SettingItemModel settingItemModel) {
        Intrinsics.checkNotNullParameter(settingItemModel, "<unused var>");
        return Unit.INSTANCE;
    }

    public final Function3<Integer, Integer, SettingItemModel, Unit> getOnUpdateSettings() {
        return this.onUpdateSettings;
    }

    public final Function1<Integer, Unit> getOnClickLink() {
        return this.onClickLink;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public SettingItemViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.setting_item, parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        return new SettingItemViewHolder(inflate);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(SettingItemViewHolder holder, int i) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        SettingItemModel settingItemModel = this.settingItems.get(i);
        Intrinsics.checkNotNullExpressionValue(settingItemModel, "get(...)");
        SettingItemModel settingItemModel2 = settingItemModel;
        SettingItemBinding binding = holder.getBinding();
        binding.settingName.setText(settingItemModel2.getName());
        SwitchCompat switchSetting = binding.switchSetting;
        Intrinsics.checkNotNullExpressionValue(switchSetting, "switchSetting");
        switchSetting.setVisibility(8);
        LinearLayout sliderSettingContainer = binding.sliderSettingContainer;
        Intrinsics.checkNotNullExpressionValue(sliderSettingContainer, "sliderSettingContainer");
        sliderSettingContainer.setVisibility(8);
        LinearLayout selectorSettingGroup = binding.selectorSettingGroup;
        Intrinsics.checkNotNullExpressionValue(selectorSettingGroup, "selectorSettingGroup");
        selectorSettingGroup.setVisibility(8);
        LinearLayout switchTextSettingContainer = binding.switchTextSettingContainer;
        Intrinsics.checkNotNullExpressionValue(switchTextSettingContainer, "switchTextSettingContainer");
        switchTextSettingContainer.setVisibility(8);
        LinearLayout linkTextSettingContainer = binding.linkTextSettingContainer;
        Intrinsics.checkNotNullExpressionValue(linkTextSettingContainer, "linkTextSettingContainer");
        linkTextSettingContainer.setVisibility(8);
        SettingType type = settingItemModel2.getType();
        if (type instanceof SettingType.SettingSwitcher) {
            setupSwitcherUi(holder, (SettingType.SettingSwitcher) type);
        } else if (type instanceof SettingType.SettingSlider) {
            setupSliderUi(holder, (SettingType.SettingSlider) type);
        } else if (type instanceof SettingType.SettingSelector) {
            setupSelectorsUi(holder, (SettingType.SettingSelector) type);
        } else if (type instanceof SettingType.SettingTextSwitcher) {
            setupTextSwitcherUi(holder, (SettingType.SettingTextSwitcher) type);
        } else if (!(type instanceof SettingType.SettingLink)) {
            throw new NoWhenBranchMatchedException();
        } else {
            setupLinkUi(holder, (SettingType.SettingLink) type);
        }
    }

    private final void updateSettings(int i, SettingType settingType) {
        SettingItemModel settingItemModel = this.settingItems.get(i);
        Intrinsics.checkNotNullExpressionValue(settingItemModel, "get(...)");
        SettingItemModel settingItemModel2 = settingItemModel;
        settingItemModel2.setType(settingType);
        this.onUpdateSettings.invoke(Integer.valueOf(this.settingType), Integer.valueOf(i), settingItemModel2);
    }

    private final void setupSwitcherUi(final SettingItemViewHolder settingItemViewHolder, SettingType.SettingSwitcher settingSwitcher) {
        SettingItemBinding binding = settingItemViewHolder.getBinding();
        SwitchCompat switchSetting = binding.switchSetting;
        Intrinsics.checkNotNullExpressionValue(switchSetting, "switchSetting");
        switchSetting.setVisibility(0);
        binding.switchSetting.setChecked(settingSwitcher.isSwitched());
        binding.switchSetting.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: ru.mrlargha.commonui.elements.settingsMenu.SettingsAdapter$$ExternalSyntheticLambda3
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                SettingsAdapter.setupSwitcherUi$lambda$0$0(SettingsAdapter.this, settingItemViewHolder, compoundButton, z);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupSwitcherUi$lambda$0$0(SettingsAdapter settingsAdapter, SettingItemViewHolder settingItemViewHolder, CompoundButton compoundButton, boolean z) {
        Intrinsics.checkNotNullParameter(compoundButton, "<unused var>");
        settingsAdapter.updateSettings(settingItemViewHolder.getSettingItemPosition(), new SettingType.SettingSwitcher(z));
    }

    private final void setupLinkUi(SettingItemViewHolder settingItemViewHolder, final SettingType.SettingLink settingLink) {
        SettingItemBinding binding = settingItemViewHolder.getBinding();
        LinearLayout linkTextSettingContainer = binding.linkTextSettingContainer;
        Intrinsics.checkNotNullExpressionValue(linkTextSettingContainer, "linkTextSettingContainer");
        linkTextSettingContainer.setVisibility(0);
        binding.linkTextSetting.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.settingsMenu.SettingsAdapter$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SettingsAdapter.setupLinkUi$lambda$0$0(SettingsAdapter.this, settingLink, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupLinkUi$lambda$0$0(SettingsAdapter settingsAdapter, SettingType.SettingLink settingLink, View view) {
        settingsAdapter.onClickLink.invoke(Integer.valueOf(settingLink.getId()));
    }

    private final void setupTextSwitcherUi(final SettingItemViewHolder settingItemViewHolder, final SettingType.SettingTextSwitcher settingTextSwitcher) {
        final SettingItemBinding binding = settingItemViewHolder.getBinding();
        LinearLayout switchTextSettingContainer = binding.switchTextSettingContainer;
        Intrinsics.checkNotNullExpressionValue(switchTextSettingContainer, "switchTextSettingContainer");
        switchTextSettingContainer.setVisibility(0);
        boolean z = settingTextSwitcher.getValues().size() > 1;
        binding.switchTextSettingBack.setEnabled(z);
        binding.switchTextSettingForward.setEnabled(z);
        binding.switchTextSettingBack.setAlpha(z ? 1.0f : 0.35f);
        binding.switchTextSettingForward.setAlpha(z ? 1.0f : 0.35f);
        int coerceIn = RangesKt.coerceIn(settingTextSwitcher.getIndexSelect(), 0, settingTextSwitcher.getValues().size() - 1);
        binding.switchTextSetting.setText(settingTextSwitcher.getValues().get(coerceIn));
        final Ref.IntRef intRef = new Ref.IntRef();
        intRef.element = coerceIn;
        binding.switchTextSettingBack.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.settingsMenu.SettingsAdapter$$ExternalSyntheticLambda8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SettingsAdapter.setupTextSwitcherUi$lambda$0$0(Ref.IntRef.this, binding, settingTextSwitcher, this, settingItemViewHolder, view);
            }
        });
        binding.switchTextSettingForward.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.settingsMenu.SettingsAdapter$$ExternalSyntheticLambda9
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SettingsAdapter.setupTextSwitcherUi$lambda$0$1(Ref.IntRef.this, settingTextSwitcher, binding, this, settingItemViewHolder, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupTextSwitcherUi$lambda$0$0(Ref.IntRef intRef, SettingItemBinding settingItemBinding, SettingType.SettingTextSwitcher settingTextSwitcher, SettingsAdapter settingsAdapter, SettingItemViewHolder settingItemViewHolder, View view) {
        intRef.element = intRef.element + (-1) >= 0 ? intRef.element - 1 : intRef.element;
        if (intRef.element != -1) {
            settingItemBinding.switchTextSetting.setText(settingTextSwitcher.getValues().get(intRef.element));
            settingsAdapter.updateSettings(settingItemViewHolder.getSettingItemPosition(), new SettingType.SettingTextSwitcher(settingTextSwitcher.getValues(), intRef.element));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupTextSwitcherUi$lambda$0$1(Ref.IntRef intRef, SettingType.SettingTextSwitcher settingTextSwitcher, SettingItemBinding settingItemBinding, SettingsAdapter settingsAdapter, SettingItemViewHolder settingItemViewHolder, View view) {
        intRef.element = intRef.element + 1 <= settingTextSwitcher.getValues().size() + (-1) ? intRef.element + 1 : intRef.element;
        if (intRef.element != -1) {
            settingItemBinding.switchTextSetting.setText(settingTextSwitcher.getValues().get(intRef.element));
            settingsAdapter.updateSettings(settingItemViewHolder.getSettingItemPosition(), new SettingType.SettingTextSwitcher(settingTextSwitcher.getValues(), intRef.element));
        }
    }

    private final void setupSliderUi(final SettingItemViewHolder settingItemViewHolder, SettingType.SettingSlider settingSlider) {
        final SettingType.SettingSlider settingSlider2;
        final SettingItemBinding binding = settingItemViewHolder.getBinding();
        LinearLayout sliderSettingContainer = binding.sliderSettingContainer;
        Intrinsics.checkNotNullExpressionValue(sliderSettingContainer, "sliderSettingContainer");
        sliderSettingContainer.setVisibility(0);
        binding.sliderSetting.clearOnChangeListeners();
        binding.sliderSetting.setValueFrom(settingSlider.getMinValue());
        binding.sliderSetting.setValueTo(settingSlider.getMaxValue());
        binding.sliderSetting.setTickVisible(settingSlider.getStep() > 1);
        binding.sliderSetting.setStepSize(settingSlider.getStep());
        float coerceIn = RangesKt.coerceIn(settingSlider.getValue(), settingSlider.getMinValue(), settingSlider.getMaxValue());
        binding.sliderSetting.setValue(coerceIn);
        int i = (int) coerceIn;
        binding.sliderSettingText.setText(i + "%");
        if (i != settingSlider.getValue()) {
            settingSlider2 = settingSlider;
            updateSettings(settingItemViewHolder.getSettingItemPosition(), SettingType.SettingSlider.copy$default(settingSlider2, i, 0.0f, 0.0f, 0, 14, null));
        } else {
            settingSlider2 = settingSlider;
        }
        binding.sliderSetting.addOnChangeListener(new Slider.OnChangeListener() { // from class: ru.mrlargha.commonui.elements.settingsMenu.SettingsAdapter$$ExternalSyntheticLambda2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.google.android.material.slider.Slider.OnChangeListener, com.google.android.material.slider.BaseOnChangeListener
            public final void onValueChange(Slider slider, float f, boolean z) {
                SettingsAdapter.setupSliderUi$lambda$0$0(SettingItemBinding.this, this, settingItemViewHolder, settingSlider2, slider, f, z);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupSliderUi$lambda$0$0(SettingItemBinding settingItemBinding, SettingsAdapter settingsAdapter, SettingItemViewHolder settingItemViewHolder, SettingType.SettingSlider settingSlider, Slider slider, float f, boolean z) {
        Intrinsics.checkNotNullParameter(slider, "<unused var>");
        int i = (int) f;
        settingItemBinding.sliderSettingText.setText(i + "%");
        settingsAdapter.updateSettings(settingItemViewHolder.getSettingItemPosition(), SettingType.SettingSlider.copy$default(settingSlider, i, 0.0f, 0.0f, 0, 14, null));
    }

    private final void setupSelectorsUi(final SettingItemViewHolder settingItemViewHolder, SettingType.SettingSelector settingSelector) {
        final SettingItemBinding binding = settingItemViewHolder.getBinding();
        LinearLayout selectorSettingGroup = binding.selectorSettingGroup;
        Intrinsics.checkNotNullExpressionValue(selectorSettingGroup, "selectorSettingGroup");
        selectorSettingGroup.setVisibility(0);
        int size = settingSelector.getValues().size();
        if (size == 2) {
            RelativeLayout settingSelector1 = binding.settingSelector1;
            Intrinsics.checkNotNullExpressionValue(settingSelector1, "settingSelector1");
            settingSelector1.setVisibility(0);
            RelativeLayout settingSelector12 = binding.settingSelector1;
            Intrinsics.checkNotNullExpressionValue(settingSelector12, "settingSelector1");
            settingSelector12.setVisibility(0);
            RelativeLayout settingSelector25 = binding.settingSelector25;
            Intrinsics.checkNotNullExpressionValue(settingSelector25, "settingSelector25");
            settingSelector25.setVisibility(8);
            RelativeLayout settingSelector30 = binding.settingSelector30;
            Intrinsics.checkNotNullExpressionValue(settingSelector30, "settingSelector30");
            settingSelector30.setVisibility(8);
            binding.settingSelector1Txt.setText(settingSelector.getValues().get(0));
            binding.settingSelector15Txt.setText(settingSelector.getValues().get(1));
        } else if (size == 3) {
            RelativeLayout settingSelector13 = binding.settingSelector1;
            Intrinsics.checkNotNullExpressionValue(settingSelector13, "settingSelector1");
            settingSelector13.setVisibility(0);
            RelativeLayout settingSelector14 = binding.settingSelector1;
            Intrinsics.checkNotNullExpressionValue(settingSelector14, "settingSelector1");
            settingSelector14.setVisibility(0);
            RelativeLayout settingSelector252 = binding.settingSelector25;
            Intrinsics.checkNotNullExpressionValue(settingSelector252, "settingSelector25");
            settingSelector252.setVisibility(0);
            RelativeLayout settingSelector302 = binding.settingSelector30;
            Intrinsics.checkNotNullExpressionValue(settingSelector302, "settingSelector30");
            settingSelector302.setVisibility(8);
            binding.settingSelector1Txt.setText(settingSelector.getValues().get(0));
            binding.settingSelector15Txt.setText(settingSelector.getValues().get(1));
            binding.settingSelector25Txt.setText(settingSelector.getValues().get(2));
        } else if (size == 4) {
            RelativeLayout settingSelector15 = binding.settingSelector1;
            Intrinsics.checkNotNullExpressionValue(settingSelector15, "settingSelector1");
            settingSelector15.setVisibility(0);
            RelativeLayout settingSelector16 = binding.settingSelector1;
            Intrinsics.checkNotNullExpressionValue(settingSelector16, "settingSelector1");
            settingSelector16.setVisibility(0);
            RelativeLayout settingSelector253 = binding.settingSelector25;
            Intrinsics.checkNotNullExpressionValue(settingSelector253, "settingSelector25");
            settingSelector253.setVisibility(0);
            RelativeLayout settingSelector303 = binding.settingSelector30;
            Intrinsics.checkNotNullExpressionValue(settingSelector303, "settingSelector30");
            settingSelector303.setVisibility(0);
            binding.settingSelector1Txt.setText(settingSelector.getValues().get(0));
            binding.settingSelector15Txt.setText(settingSelector.getValues().get(1));
            binding.settingSelector25Txt.setText(settingSelector.getValues().get(2));
            binding.settingSelector30Txt.setText(settingSelector.getValues().get(3));
        }
        binding.settingSelector1.setBackgroundResource(R.drawable.setting_chip_disabled);
        binding.settingSelector15.setBackgroundResource(R.drawable.setting_chip_disabled);
        binding.settingSelector25.setBackgroundResource(R.drawable.setting_chip_disabled);
        binding.settingSelector30.setBackgroundResource(R.drawable.setting_chip_disabled);
        int coerceIn = RangesKt.coerceIn(settingSelector.getIndexSelect(), 0, settingSelector.getValues().size() - 1);
        if (coerceIn == 0) {
            binding.settingSelector1.setBackgroundResource(R.drawable.setting_chip_enabled);
        } else if (coerceIn == 1) {
            binding.settingSelector15.setBackgroundResource(R.drawable.setting_chip_enabled);
        } else if (coerceIn == 2) {
            binding.settingSelector25.setBackgroundResource(R.drawable.setting_chip_enabled);
        } else if (coerceIn == 3) {
            binding.settingSelector30.setBackgroundResource(R.drawable.setting_chip_enabled);
        }
        binding.settingSelector1.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.settingsMenu.SettingsAdapter$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SettingsAdapter.setupSelectorsUi$lambda$0$0(SettingsAdapter.this, settingItemViewHolder, binding, view);
            }
        });
        binding.settingSelector15.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.settingsMenu.SettingsAdapter$$ExternalSyntheticLambda5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SettingsAdapter.setupSelectorsUi$lambda$0$1(SettingsAdapter.this, settingItemViewHolder, binding, view);
            }
        });
        binding.settingSelector25.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.settingsMenu.SettingsAdapter$$ExternalSyntheticLambda6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SettingsAdapter.setupSelectorsUi$lambda$0$2(SettingsAdapter.this, settingItemViewHolder, binding, view);
            }
        });
        binding.settingSelector30.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.settingsMenu.SettingsAdapter$$ExternalSyntheticLambda7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SettingsAdapter.setupSelectorsUi$lambda$0$3(SettingsAdapter.this, settingItemViewHolder, binding, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupSelectorsUi$lambda$0$0(SettingsAdapter settingsAdapter, SettingItemViewHolder settingItemViewHolder, SettingItemBinding settingItemBinding, View view) {
        settingsAdapter.unselectOtherSelectors(settingItemViewHolder);
        settingItemBinding.settingSelector1.setBackgroundResource(R.drawable.setting_chip_enabled);
        settingsAdapter.savedSelectInList(settingItemViewHolder.getSettingItemPosition(), 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupSelectorsUi$lambda$0$1(SettingsAdapter settingsAdapter, SettingItemViewHolder settingItemViewHolder, SettingItemBinding settingItemBinding, View view) {
        settingsAdapter.unselectOtherSelectors(settingItemViewHolder);
        settingItemBinding.settingSelector15.setBackgroundResource(R.drawable.setting_chip_enabled);
        settingsAdapter.savedSelectInList(settingItemViewHolder.getSettingItemPosition(), 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupSelectorsUi$lambda$0$2(SettingsAdapter settingsAdapter, SettingItemViewHolder settingItemViewHolder, SettingItemBinding settingItemBinding, View view) {
        settingsAdapter.unselectOtherSelectors(settingItemViewHolder);
        settingItemBinding.settingSelector25.setBackgroundResource(R.drawable.setting_chip_enabled);
        settingsAdapter.savedSelectInList(settingItemViewHolder.getSettingItemPosition(), 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupSelectorsUi$lambda$0$3(SettingsAdapter settingsAdapter, SettingItemViewHolder settingItemViewHolder, SettingItemBinding settingItemBinding, View view) {
        settingsAdapter.unselectOtherSelectors(settingItemViewHolder);
        settingItemBinding.settingSelector30.setBackgroundResource(R.drawable.setting_chip_enabled);
        settingsAdapter.savedSelectInList(settingItemViewHolder.getSettingItemPosition(), 3);
    }

    private final void savedSelectInList(int i, int i2) {
        SettingType type = this.settingItems.get(i).getType();
        Intrinsics.checkNotNull(type, "null cannot be cast to non-null type ru.mrlargha.commonui.elements.settingsMenu.model.SettingType.SettingSelector");
        SettingType.SettingSelector settingSelector = (SettingType.SettingSelector) type;
        settingSelector.setIndexSelect(i2);
        updateSettings(i, settingSelector);
    }

    private final void unselectOtherSelectors(SettingItemViewHolder settingItemViewHolder) {
        SettingItemBinding binding = settingItemViewHolder.getBinding();
        binding.settingSelector1.setBackgroundResource(R.drawable.setting_chip_disabled);
        binding.settingSelector15.setBackgroundResource(R.drawable.setting_chip_disabled);
        binding.settingSelector25.setBackgroundResource(R.drawable.setting_chip_disabled);
        binding.settingSelector30.setBackgroundResource(R.drawable.setting_chip_disabled);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.settingItems.size();
    }

    public final void clear() {
        int size = this.settingItems.size();
        this.settingItems.clear();
        if (size > 0) {
            notifyItemRangeRemoved(0, size);
        }
    }

    public final void setSettings(int i, List<SettingItemModel> settings) {
        Intrinsics.checkNotNullParameter(settings, "settings");
        this.settingType = i;
        this.settingItems.clear();
        this.settingItems.addAll(settings);
        notifyDataSetChanged();
    }
}
