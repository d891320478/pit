#include <__algorithm/min.h>

#include <iostream>
#include <map>
#include <string>

using namespace std;

class Solution {
public:
    map<string, int> mp;

    int f(string s, int d) {
        if (s.length() < 3) {
            return 0;
        }
        if (mp.find(s) != mp.end()) {
            return mp[s];
        }

        int j = s.length() - 1;
        for (; j > 0 && s[j] != s[0]; --j);
        int v;
        if (j == 0) {
            v = s.length() / 2 + f(s.substr(1), d + 1);
        } else {
            v = s.length() - j - 1 +
                f((j - 1 >= 1 ? s.substr(1, j - 1) : "") +
                    (j + 1 < s.length() ? s.substr(j + 1) : ""),
                    d + 1);
        }
        return mp[s] = v;
    }

    int minMovesToMakePalindrome(string s) {
        return f(s, 0);
    }
} a;

int main() {
    cout
        << a.minMovesToMakePalindrome(
            "pladobzcqhembvtziogcxpgvoxzehtogyytwolejhkivxbxcsliilkxzozimydugezmsifmzmnovfxhlyttcstwlemtlfxogtsxgexwgebelkcbhtbmmzflzbfexemcutqqcjrinlxkvuehsmveybtzogthuuoiesrydgkfolcmmvkqrztmmkminpzvixvqncjszmqpviwydmcxwcvbnofhduhybahtarmgcvmfacodidguduuaaljrjzxwsrhzhxzhtqjvtzxtzahdebxdrtsomnkwesrlnnhalzibjkvrtnyqzadxgwsrthjijxffkzekyqklwnmxyzkonyjhgmlbezszddxskvuaynqqkzehzhpideulzoekkzucbrnbxypoyjrdgjviplqklgdnugdjrcyddxikptqovtkvlrcrvyijckbxzukktdbkxcwsqgdvvpzpqwqngjjhnbmbhgqclwvabceqnkzzcsopkrgsuuknjzsmssysnpvwofynbobsyunsogzuunsiwrmbjkrfkmmibisyocnjwbdjgtnghkhzxfitkhrtezfczheodpxiyrnxoqxngsypxdlagbqkvwyzezeorvkxgovgfajiussguipupccwngawefntxtctawjqmkkkadrmqykzufbrxvakrwxtjsbgkqdhtavjsstfgszdtgwkfggfwvihhbyujqiraravmynkiuwmsruolytjdsapkxdtzybfbjajdotavsslbsfnunjlibtkyjkacxedazihjxdcopocyaugwcffhyovkwwmgvptqsknmlwtaobifrgkbcwppsaceamfzcpsuhhuyinatljmmoyidtxwnpzvjutxxhhmbgrmckytcynouyjqstsepbzstiajbgalkgzrypoglihrhdaihtnbborkuejktmxezotrvjigtyhmdoytzjdtrwmpigxqzbmtnbsuxhcfvphmxabhcmluqbjrzlmfnnmgkyvqhyqmdzbhtjetlxivthylfoylqkjcgesjogjjmebbmztoxleeqcgycvckhsbfxwohpbdnuprkwquscdavkddxmgcamrafzsrzrgrxpxvnlialxxrsacdoyyyugxecvgqneprulbtnnhxrtbnhtcazhysifbkytredwhvuxzmdkosjftqasyfvukohutcyegbzwhpvkofhkdrylduybihvxjfoyprcdpbaxiwknlyipammfzqaqpzqctncmckvzgcpvrhoujxmogfutgybcgiftqgzetaxfwwyseviexrrmatuztlwthnqqzomlfaintgoyvbzacdimfaajccwogsotdpcafidxchpfudmaitillthfkvggczorjrtpcaslpomktzraeteyxdyksaccwjiaokhtgroexycelrixnhawpvwljchfzampbgbllpgnunjkiozopymrpxzrmshvesrjgreledanznkhgnlgththlqvyfbdeweszmipivvlkwkyxsvtxvoelclafncrtcuyoxxeknrwprpgczjleppeywrncvkbvhzrmeribuzcheddyvtjasltvxgzugfqicqamairpkaautexfqasdyinzcdtgquzjbvhvxwqcpgvlsfzrlpvjxuhxnhmmlgtptqosompgjbjjeiwltrurhgrxmqjkgvqrmxnelzbgawvtrnkgmwdqlmmhkkqfqaglqvltrgemvfbybplfeofobwmgejiprrtmsmdotsumppvvschofhgw")
        << endl;
    return 0;
}
