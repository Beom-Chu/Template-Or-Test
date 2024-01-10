package com.kbs.templateortest.lombok;

import com.kbs.templateortest.lombok.tostring.exclude.dto.MemberEx;
import com.kbs.templateortest.lombok.tostring.exclude.dto.TeamEx;
import org.junit.jupiter.api.Test;

public class LombokTest {

    @Test
    public void testToStringExclude() {
        /* 양방향 맵핑된 객체는 String으로 변환시 StackOverflowError 발생 */
//        Member member = new Member();
//        Team team = new Team();

        /* @ToString.Exclude 사용해서 해결 가능
        * 양방향 매핑되는 필드를 제외 시킴 */
        MemberEx member = new MemberEx();
        TeamEx team = new TeamEx();

        member.setName("bs");
        member.setAge(10);
        member.setTeam(team);
        team.setName("aTeam");
        team.getMembers().add(member);

        System.out.println(member);
    }
}
