package umc.study.spring.domain;


import jakarta.persistence.*;
import lombok.*;
import umc.study.spring.domain.common.BaseEntity;
import umc.study.spring.domain.enums.Gender;
import umc.study.spring.domain.enums.MemberStatus;
import umc.study.spring.domain.enums.SocialType;
import umc.study.spring.domain.mapping.MemberAgree;
import umc.study.spring.domain.mapping.MemberMission;
import umc.study.spring.domain.mapping.MemberPrefer;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Member extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 20)
    private String name;

    @Column(nullable = false,length = 40,columnDefinition = "VARCHAR(40) DEFAULT 'default_address'")
    private String address;

    @Column(nullable = false,length = 40,columnDefinition = "VARCHAR(40) DEFAULT 'default_spec_address'")
    private String specAddress;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "VARCHAR(10)")
    private Gender gender;

    @Enumerated(EnumType.STRING)
    private SocialType socialType;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "VARCHAR(15) DEFAULT 'ACTIVE'")
    private MemberStatus memberStatus;

    private LocalDate inactiveDate;

    private String email;

    private Integer point;

    @OneToMany(mappedBy = "member",cascade = CascadeType.ALL)
    private List<MemberAgree> memberAgreeList = new ArrayList<>();

    @OneToMany(mappedBy = "member",cascade=CascadeType.ALL)
    private List<MemberPrefer> memberPreferList = new ArrayList<>();

    @OneToMany(mappedBy = "member",cascade = CascadeType.ALL)
    private List<Review> reviewList = new ArrayList<>();

    @OneToMany(mappedBy = "member",cascade = CascadeType.ALL)
    private List<MemberMission> memberMissionList= new ArrayList<>();
}