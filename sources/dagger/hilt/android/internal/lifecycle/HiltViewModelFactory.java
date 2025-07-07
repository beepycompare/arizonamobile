package dagger.hilt.android.internal.lifecycle;

import android.app.Activity;
import android.os.Bundle;
import androidx.lifecycle.SavedStateHandleSupport;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.savedstate.SavedStateRegistryOwner;
import dagger.Module;
import dagger.hilt.EntryPoints;
import dagger.hilt.android.components.ViewModelComponent;
import dagger.hilt.android.internal.builders.ViewModelComponentBuilder;
import dagger.multibindings.Multibinds;
import java.io.Closeable;
import java.util.Map;
import java.util.Objects;
import javax.inject.Provider;
import kotlin.jvm.functions.Function1;
/* loaded from: classes4.dex */
public final class HiltViewModelFactory implements ViewModelProvider.Factory {
    public static final CreationExtras.Key<Function1<Object, ViewModel>> CREATION_CALLBACK_KEY = new CreationExtras.Key<Function1<Object, ViewModel>>() { // from class: dagger.hilt.android.internal.lifecycle.HiltViewModelFactory.1
    };
    private final ViewModelProvider.Factory delegateFactory;
    private final ViewModelProvider.Factory hiltViewModelFactory;
    private final Map<Class<?>, Boolean> hiltViewModelKeys;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public interface ActivityCreatorEntryPoint {
        ViewModelComponentBuilder getViewModelComponentBuilder();

        Map<Class<?>, Boolean> getViewModelKeys();
    }

    /* loaded from: classes4.dex */
    public interface ViewModelFactoriesEntryPoint {
        Map<Class<?>, Object> getHiltViewModelAssistedMap();

        Map<Class<?>, Provider<ViewModel>> getHiltViewModelMap();
    }

    @Module
    /* loaded from: classes4.dex */
    interface ViewModelModule {
        @Multibinds
        Map<Class<?>, Object> hiltViewModelAssistedMap();

        @Multibinds
        Map<Class<?>, ViewModel> hiltViewModelMap();
    }

    public HiltViewModelFactory(Map<Class<?>, Boolean> hiltViewModelKeys, ViewModelProvider.Factory delegateFactory, final ViewModelComponentBuilder viewModelComponentBuilder) {
        this.hiltViewModelKeys = hiltViewModelKeys;
        this.delegateFactory = delegateFactory;
        this.hiltViewModelFactory = new ViewModelProvider.Factory() { // from class: dagger.hilt.android.internal.lifecycle.HiltViewModelFactory.2
            @Override // androidx.lifecycle.ViewModelProvider.Factory
            public <T extends ViewModel> T create(Class<T> modelClass, CreationExtras extras) {
                final RetainedLifecycleImpl retainedLifecycleImpl = new RetainedLifecycleImpl();
                T t = (T) createViewModel(viewModelComponentBuilder.savedStateHandle(SavedStateHandleSupport.createSavedStateHandle(extras)).viewModelLifecycle(retainedLifecycleImpl).build(), modelClass, extras);
                Objects.requireNonNull(retainedLifecycleImpl);
                t.addCloseable(new Closeable() { // from class: dagger.hilt.android.internal.lifecycle.HiltViewModelFactory$2$$ExternalSyntheticLambda0
                    @Override // java.io.Closeable, java.lang.AutoCloseable
                    public final void close() {
                        RetainedLifecycleImpl.this.dispatchOnCleared();
                    }
                });
                return t;
            }

            private <T extends ViewModel> T createViewModel(ViewModelComponent component, Class<T> modelClass, CreationExtras extras) {
                Provider<ViewModel> provider = ((ViewModelFactoriesEntryPoint) EntryPoints.get(component, ViewModelFactoriesEntryPoint.class)).getHiltViewModelMap().get(modelClass);
                Function1 function1 = (Function1) extras.get(HiltViewModelFactory.CREATION_CALLBACK_KEY);
                Object obj = ((ViewModelFactoriesEntryPoint) EntryPoints.get(component, ViewModelFactoriesEntryPoint.class)).getHiltViewModelAssistedMap().get(modelClass);
                if (obj == null) {
                    if (function1 == null) {
                        if (provider == null) {
                            throw new IllegalStateException("Expected the @HiltViewModel-annotated class " + modelClass.getName() + " to be available in the multi-binding of @HiltViewModelMap but none was found.");
                        }
                        return (T) provider.get();
                    }
                    throw new IllegalStateException("Found creation callback but class " + modelClass.getName() + " does not have an assisted factory specified in @HiltViewModel.");
                } else if (provider == null) {
                    if (function1 == null) {
                        throw new IllegalStateException("Found @HiltViewModel-annotated class " + modelClass.getName() + " using @AssistedInject but no creation callback was provided in CreationExtras.");
                    }
                    return (T) function1.invoke(obj);
                } else {
                    throw new AssertionError("Found the @HiltViewModel-annotated class " + modelClass.getName() + " in both the multi-bindings of @HiltViewModelMap and @HiltViewModelAssistedMap.");
                }
            }
        };
    }

    @Override // androidx.lifecycle.ViewModelProvider.Factory
    public <T extends ViewModel> T create(Class<T> modelClass, CreationExtras extras) {
        if (this.hiltViewModelKeys.containsKey(modelClass)) {
            return (T) this.hiltViewModelFactory.create(modelClass, extras);
        }
        return (T) this.delegateFactory.create(modelClass, extras);
    }

    @Override // androidx.lifecycle.ViewModelProvider.Factory
    public <T extends ViewModel> T create(Class<T> modelClass) {
        if (this.hiltViewModelKeys.containsKey(modelClass)) {
            return (T) this.hiltViewModelFactory.create(modelClass);
        }
        return (T) this.delegateFactory.create(modelClass);
    }

    public static ViewModelProvider.Factory createInternal(Activity activity, SavedStateRegistryOwner owner, Bundle defaultArgs, ViewModelProvider.Factory delegateFactory) {
        return createInternal(activity, delegateFactory);
    }

    public static ViewModelProvider.Factory createInternal(Activity activity, ViewModelProvider.Factory delegateFactory) {
        ActivityCreatorEntryPoint activityCreatorEntryPoint = (ActivityCreatorEntryPoint) EntryPoints.get(activity, ActivityCreatorEntryPoint.class);
        return new HiltViewModelFactory(activityCreatorEntryPoint.getViewModelKeys(), delegateFactory, activityCreatorEntryPoint.getViewModelComponentBuilder());
    }
}
