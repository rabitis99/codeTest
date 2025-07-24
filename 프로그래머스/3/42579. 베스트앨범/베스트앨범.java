
import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public int[] solution(String[] genres, int[] plays) {

        // 1. 장르별 총 재생 수 집계
        Map<String, Integer> genrePlayCount = new HashMap<>();
        // 2. 장르별 곡 정보 저장 (곡 index와 재생 수)
        Map<String, List<int[]>> genreToSongs = new HashMap<>();

        // 장르별 랭킹과 장르별 노래 정리
        for (int i=0; i<plays.length; i++){

            genrePlayCount.put(genres[i],genrePlayCount.getOrDefault(genres[i],0)+plays[i]);

            // 여긴 암기
            genreToSongs.computeIfAbsent
                    (genres[i],k->new ArrayList<>()).add(new int[]{i,plays[i]});

        }
        /*
         참고자료
        entrySet : Map 전체 출력
        sorted((a,b)-> b.getValue()-a.getValue()) 큰 순서
        sorted((a,b)-> a.getValue()-b.getValue()) 작은 순서
        sorted() 알파벳 순서
        */
        
        List<String> sortedGenres = genrePlayCount.entrySet()
                .stream()
                .sorted((a,b)-> b.getValue()-a.getValue())
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        List<Integer> result = new ArrayList<>();

        // 장르별 노래 갯수
        for (String genre : sortedGenres){

            List<int[]> songs = genreToSongs.get(genre);

            songs.sort((a, b) -> b[1] != a[1] ? b[1] - a[1] : a[0] - b[0]);

            for (int i = 0; i < Math.min(2, songs.size()); i++) {
                result.add(songs.get(i)[0]);  // 고유 번호
            }

        }


        return result.stream().mapToInt(i->i).toArray();
    }
}