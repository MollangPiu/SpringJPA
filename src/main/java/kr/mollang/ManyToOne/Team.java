package kr.mollang.ManyToOne;

import java.lang.reflect.Member;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
class Team {

    @Id
    @Column(name="TEAM_ID")
    private Long id;
    private String teamName;

    @OneToMany(mappedBy = "team")
    private List<MemberTest> member = new ArrayList<MemberTest>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public List<MemberTest> getMember() {
        return member;
    }

    public void setMember(List<MemberTest> member) {
        this.member = member;
    }
}
