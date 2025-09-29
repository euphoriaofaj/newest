package com.morago.backend.entity;

import com.morago.backend.listener.Auditable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Set;

@Entity
@Table(name = "themes")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Theme extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false, unique = true, length = 200)
    private String name;

    @Column(name = "korean_title", length = 200)
    private String koreanTitle;

    @Column(name = "price", precision = 10, scale = 2)
    private BigDecimal price;

    @Column(name = "night_price", precision = 10, scale = 2)
    private BigDecimal nightPrice;

    @Column(name = "description", length = 500)
    private String description;

    @Column(name = "is_popular")
    @Builder.Default
    private boolean isPopular = false;

    @Column(name = "is_active")
    @Builder.Default
    private boolean isActive = true;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToMany(mappedBy = "themes")
    @Builder.Default
    private Set<TranslatorProfile> translators = new java.util.HashSet<>();

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "icon_file_id", unique = true)
    private File icon;
}