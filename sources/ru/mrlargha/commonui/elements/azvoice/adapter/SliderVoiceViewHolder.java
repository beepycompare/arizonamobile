package ru.mrlargha.commonui.elements.azvoice.adapter;

import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.android.material.slider.Slider;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import ru.mrlargha.commonui.databinding.SoundSliderBinding;
import ru.mrlargha.commonui.elements.azvoice.SoundSliderData;
/* compiled from: SliderVoiceViewHolder.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u001e\u0010\u0004\u001a\u001a\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R&\u0010\u0004\u001a\u001a\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lru/mrlargha/commonui/elements/azvoice/adapter/SliderVoiceViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lru/mrlargha/commonui/databinding/SoundSliderBinding;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lkotlin/Function3;", "", "", "<init>", "(Lru/mrlargha/commonui/databinding/SoundSliderBinding;Lkotlin/jvm/functions/Function3;)V", "bind", "item", "Lru/mrlargha/commonui/elements/azvoice/SoundSliderData;", "CommonUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SliderVoiceViewHolder extends RecyclerView.ViewHolder {
    private final SoundSliderBinding binding;
    private final Function3<Integer, Integer, Integer, Unit> listener;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public SliderVoiceViewHolder(SoundSliderBinding binding, Function3<? super Integer, ? super Integer, ? super Integer, Unit> listener) {
        super(binding.getRoot());
        Intrinsics.checkNotNullParameter(binding, "binding");
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.binding = binding;
        this.listener = listener;
    }

    public final void bind(final SoundSliderData item) {
        Intrinsics.checkNotNullParameter(item, "item");
        final SoundSliderBinding soundSliderBinding = this.binding;
        soundSliderBinding.slider.setValueFrom(item.getMinValue());
        soundSliderBinding.slider.setValueTo(item.getMaxValue());
        soundSliderBinding.slider.setValue(item.getCurrentValue());
        soundSliderBinding.sliderName.setText(item.getName());
        soundSliderBinding.sliderValue.setText(item.getCurrentValue() + "%");
        soundSliderBinding.slider.addOnChangeListener(new Slider.OnChangeListener() { // from class: ru.mrlargha.commonui.elements.azvoice.adapter.SliderVoiceViewHolder$$ExternalSyntheticLambda0
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.google.android.material.slider.Slider.OnChangeListener, com.google.android.material.slider.BaseOnChangeListener
            public final void onValueChange(Slider slider, float f, boolean z) {
                SliderVoiceViewHolder.bind$lambda$1$lambda$0(SliderVoiceViewHolder.this, item, soundSliderBinding, slider, f, z);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bind$lambda$1$lambda$0(SliderVoiceViewHolder sliderVoiceViewHolder, SoundSliderData soundSliderData, SoundSliderBinding soundSliderBinding, Slider slider, float f, boolean z) {
        Intrinsics.checkNotNullParameter(slider, "<unused var>");
        int i = (int) f;
        sliderVoiceViewHolder.listener.invoke(Integer.valueOf(soundSliderData.getPlayerId()), Integer.valueOf(soundSliderData.getSliderUId()), Integer.valueOf(i));
        soundSliderBinding.sliderValue.setText(i + "%");
    }
}
