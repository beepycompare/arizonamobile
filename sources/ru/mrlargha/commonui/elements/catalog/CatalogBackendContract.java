package ru.mrlargha.commonui.elements.catalog;

import kotlin.Metadata;
/* compiled from: CatalogBackendContract.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\bÀ\u0002\u0018\u00002\u00020\u0001:\u0002\u0007\bB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lru/mrlargha/commonui/elements/catalog/CatalogBackendContract;", "", "<init>", "()V", "DEFAULT_ELEMENT_ID", "", "INITIAL_PAGE", "Incoming", "Outgoing", "CommonUI"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class CatalogBackendContract {
    public static final int DEFAULT_ELEMENT_ID = 0;
    public static final int INITIAL_PAGE = 1;
    public static final CatalogBackendContract INSTANCE = new CatalogBackendContract();

    private CatalogBackendContract() {
    }

    /* compiled from: CatalogBackendContract.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lru/mrlargha/commonui/elements/catalog/CatalogBackendContract$Incoming;", "", "<init>", "()V", "INFO", "", "LEGACY_ITEMS", "REMOVE_ITEM", "ITEMS_PAGE", "CommonUI"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class Incoming {
        public static final int INFO = 0;
        public static final Incoming INSTANCE = new Incoming();
        public static final int ITEMS_PAGE = 3;
        public static final int LEGACY_ITEMS = 1;
        public static final int REMOVE_ITEM = 2;

        private Incoming() {
        }
    }

    /* compiled from: CatalogBackendContract.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lru/mrlargha/commonui/elements/catalog/CatalogBackendContract$Outgoing;", "", "<init>", "()V", "CLOSE", "", "SELECT_ITEM", "REQUEST_PAGE", "CommonUI"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class Outgoing {
        public static final int CLOSE = 0;
        public static final Outgoing INSTANCE = new Outgoing();
        public static final int REQUEST_PAGE = 3;
        public static final int SELECT_ITEM = 1;

        private Outgoing() {
        }
    }
}
