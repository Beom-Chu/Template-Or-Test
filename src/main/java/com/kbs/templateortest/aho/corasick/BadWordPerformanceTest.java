package com.kbs.templateortest.aho.corasick;

import org.ahocorasick.trie.Emit;
import org.ahocorasick.trie.Trie;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class BadWordPerformanceTest {

    private static int initDummyBadwordCnt = 100_000; //더미용 금칙어 초기화 갯수

    private static final String findBadword = "개새끼"; //테스트용 금칙어
    private static final String findBadword2 = "소새끼"; //테스트용 금칙어2

    private static LinkedHashSet<String> badwords = new LinkedHashSet<>(); //linkedhaset이 contain 성능이 가장 좋음: https://dzone.com/articles/java-collection-performance
    private static Trie badwordsTrie; //아호코라식용

    @BeforeAll
    static void init() {

        for (int i = 1; i <= initDummyBadwordCnt; i++) {

            //String randomBadWord = RandomStringUtils.random(30, false, false);
            String randomBadWord = RandomStringUtils.randomAlphanumeric(30);
            badwords.add(randomBadWord);
        }

        System.out.printf("init 금칙어 갯수(컬렉션용): %d%n", badwords.size());

        //아호코라식용 초기화
        long startInitAho = System.currentTimeMillis();
        badwordsTrie = Trie.builder().addKeywords(badwords).addKeyword(findBadword).addKeyword(findBadword2).build(); //시간이 많이걸리니까 가능하면 초기화 후 재 사용
        //badwordsTrie = Trie.builder().addKeywords(badwords).addKeyword(findBadword).addKeyword(findBadword2).onlyWholeWords().build(); //시간이 많이걸리니까 가능하면 초기화 후 재 사용
        //badwordsTrie = Trie.builder().ignoreCase().ignoreOverlaps().addKeywords(badwords).build(); //아호코라식용 초기화

        long endInitAho = System.currentTimeMillis();
        System.out.println("아호코라식 초기화 소요시간(ms): " + (endInitAho - startInitAho));
    }

    /**
     * 아호코라식으로도 완전일치 테스트가 가능하지만 java컬렉션을 이용해서도 구현
     */
    @Test
    @Timeout(value = 20, unit = TimeUnit.MILLISECONDS)
    public void 금칙어_완전일치_테스트() {

        badwords.add(findBadword); //테스트용 금칙어를 금칙어 셋에 추가해둠(성능 테스트를 위해 만든 대량의 금칙어에 추가)

        final String notExistBadword = findBadword + System.currentTimeMillis(); //확률적으로 존재할 수 없는 금칙어

        long startExactNano = System.nanoTime();
        long startExactms = System.currentTimeMillis();

        Assertions.assertTrue(badwords.contains(findBadword));
        Assertions.assertFalse(badwords.contains(notExistBadword));

        long endExactNano = System.nanoTime();
        long endExactMs = System.currentTimeMillis();

        System.out.println("\n\n완전일치 금칙어 find 소요시간(nano): " + (endExactNano - startExactNano));
        System.out.println("완전일치 금칙어 find 소요시간(ms): " + (endExactMs - startExactms));

    }

    /**
     * 성능을 위해서 포함여부 체크는 아호코라식 알고리즘을 사용
     *  - 구현 java 라이브러리: https://github.com/robert-bor/aho-corasick (maven mvnrepository에는 배포를 안하니 참고해서 직접 구현하거나 소스 내려받아서 빌드 후 사용)
     */
    @Test
    @Timeout(value = 20, unit = TimeUnit.MILLISECONDS)
    public void 금칙어_포함여부_아호코라식알고리즘기반_테스트() {

        String targetText_1 = "개새끼들이 뛰어놀고 있어요. 소 는 없어요";
        Collection<Emit> emits_1 = excuteAho(targetText_1);
        Assertions.assertEquals(1, emits_1.size());

        String targetText_2 = "개새끼들이 뛰어놀고 있어요. 옆에는 소새끼들이 있어요";
        Collection<Emit> emits_2 = excuteAho(targetText_2);
        Assertions.assertEquals(2, emits_2.size());

        String targetText_3 = "개가 뛰어놀고 있어요. 옆에는 소도 있어요";
        Collection<Emit> emits_3 = excuteAho(targetText_3);
        System.out.println(emits_3);
        Assertions.assertEquals(0, emits_3.size());

    }

    private Collection<Emit> excuteAho(String targetText) {

        System.out.println("\n===== excuteAho: Start ");
        System.out.println("금칙어가 존재하는지 검사할 텍스트:==>" + targetText);

        long startNano = System.nanoTime();
        long startMs = System.currentTimeMillis();

        Collection<Emit> emits = badwordsTrie.parseText(targetText);
        System.out.println("검출된 금칙어 갯수: " + emits.size());
        for (Emit emit : emits) {
            System.out.printf("  금칙어 '%s'에 매칭됨%n", emit.getKeyword());
        }

        long endNano = System.nanoTime();
        long endMs = System.currentTimeMillis();

        long duNano = endNano - startNano;
        long duMs = endMs - startMs;

        System.out.printf("아호코라식 기반 금칙어 판별 소요시간. '%d(nano)' | '%d(ms)'%n", duNano, duMs);
        System.out.println("===== excuteAho: End ");

        return emits;
    }


    @Test
    public void test() {
        List<String> keywords = new ArrayList<>();
        keywords.add("개새끼");
        keywords.add("씨발");

        String contents = "씨발 이렇게 하면 내가 뭐가 되니? 개새끼야!";

        Trie trie = Trie.builder().addKeywords(keywords).build();
        boolean containsMatch = trie.containsMatch(contents);
        System.out.println("[[[containsMatch = " + containsMatch);

        Collection<Emit> emits = trie.parseText(contents);
        System.out.println("[[[emits = " + emits);


        boolean match = badwordsTrie.containsMatch("목장에서 개새끼들이 뛰어 놉니다~");
        System.out.println("[[[match = " + match);
    }
}
