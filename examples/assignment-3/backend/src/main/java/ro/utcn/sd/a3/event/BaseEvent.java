package ro.utcn.sd.a3.event;

import lombok.Data;

@Data
public class BaseEvent {
    private final EventType type;
}
