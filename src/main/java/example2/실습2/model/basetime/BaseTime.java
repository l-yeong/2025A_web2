package example2.실습2.model.basetime;

import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Getter
@MappedSuperclass

@EntityListeners(AuditingEntityListener.class)

public class BaseTime {

    @CreatedDate //현재 날짜/시간 자동으로 주입
    private LocalDateTime createdAt;

    @LastModifiedDate //엔티티 변화 시점의 날짜/시간을 자동으로 주입
    private LocalDateTime updatedAt;

}// class end
