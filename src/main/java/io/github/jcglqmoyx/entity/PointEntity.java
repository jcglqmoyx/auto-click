package io.github.jcglqmoyx.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PointEntity {
    private int x;
    private int y;
    private int button;
    private boolean isDoubleClick;
    private int delay;

    public PointEntity(int x, int y) {
        this.x = x;
        this.y = y;
    }
}