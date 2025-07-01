package com.example.common;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Version;
import java.time.LocalDateTime;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseEntity {

	@CreatedDate
	@Column(name ="created_at", updatable = false)
	protected LocalDateTime createAt;

	@LastModifiedDate
	@Column(name ="updated_at")
	protected LocalDateTime updateAt;

	@Column(name ="created_by")
	protected String createBy;

	@Column(name ="updated_by")
	protected String updateBy;

	@Version
	protected Long version;
}
