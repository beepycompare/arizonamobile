package com.google.android.datatransport;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class AutoValue_Event<T> extends Event<T> {
    private final Integer code;
    private final EventContext eventContext;
    private final T payload;
    private final Priority priority;
    private final ProductData productData;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AutoValue_Event(Integer num, T t, Priority priority, ProductData productData, EventContext eventContext) {
        this.code = num;
        if (t == null) {
            throw new NullPointerException("Null payload");
        }
        this.payload = t;
        if (priority == null) {
            throw new NullPointerException("Null priority");
        }
        this.priority = priority;
        this.productData = productData;
        this.eventContext = eventContext;
    }

    @Override // com.google.android.datatransport.Event
    public Integer getCode() {
        return this.code;
    }

    @Override // com.google.android.datatransport.Event
    public T getPayload() {
        return this.payload;
    }

    @Override // com.google.android.datatransport.Event
    public Priority getPriority() {
        return this.priority;
    }

    @Override // com.google.android.datatransport.Event
    public ProductData getProductData() {
        return this.productData;
    }

    @Override // com.google.android.datatransport.Event
    public EventContext getEventContext() {
        return this.eventContext;
    }

    public String toString() {
        return "Event{code=" + this.code + ", payload=" + this.payload + ", priority=" + this.priority + ", productData=" + this.productData + ", eventContext=" + this.eventContext + "}";
    }

    public boolean equals(Object obj) {
        ProductData productData;
        EventContext eventContext;
        if (obj == this) {
            return true;
        }
        if (obj instanceof Event) {
            Event event = (Event) obj;
            Integer num = this.code;
            if (num != null ? num.equals(event.getCode()) : event.getCode() == null) {
                if (this.payload.equals(event.getPayload()) && this.priority.equals(event.getPriority()) && ((productData = this.productData) != null ? productData.equals(event.getProductData()) : event.getProductData() == null) && ((eventContext = this.eventContext) != null ? eventContext.equals(event.getEventContext()) : event.getEventContext() == null)) {
                    return true;
                }
            }
        }
        return false;
    }

    public int hashCode() {
        Integer num = this.code;
        int hashCode = ((((((num == null ? 0 : num.hashCode()) ^ 1000003) * 1000003) ^ this.payload.hashCode()) * 1000003) ^ this.priority.hashCode()) * 1000003;
        ProductData productData = this.productData;
        int hashCode2 = (hashCode ^ (productData == null ? 0 : productData.hashCode())) * 1000003;
        EventContext eventContext = this.eventContext;
        return hashCode2 ^ (eventContext != null ? eventContext.hashCode() : 0);
    }
}
