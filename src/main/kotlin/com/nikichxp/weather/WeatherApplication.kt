package com.nikichxp.weather

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.scheduling.annotation.EnableScheduling

@EnableScheduling
@SpringBootApplication
class WeatherApplication

fun main() {

	val str1 = """
		Материнська плата ASRock B550 PHANTOM GAMING 4 sAM4 B550 4xDDR4 HDMI M.2 ATX
		3857,00
		Материнська плата ASRock B550 PHANTOM GAMING 4/AC sAM4 B550 4xDDR4 HDMI M.2 802.11ac+BT 4.2 ATX
		4235,00
		Материнська плата ASRock B550 PRO4 sAM4 B550 4xDDR4 HDMI-VGA M.2 Type-C ATX
		4537,00
		Материнська плата ASRock B550M STEEL LEGEND sAM4 B550 4xDDR4 HDMI-DP M.2 Type-C SPDIF mATX
		4870,00
		Материнcька плата ASUS PRIME_B550-PLUS sAM4 B550 4xDDR4 M.2 HDMI-DP ATX
		3800,00
		Материнcька плата ASUS PRIME_B550M-A sAM4 B550 4xDDR4 M.2 HDMI-DVI-VGA mATX
		3700,00
		Материнcька плата ASUS PRIME_B550M-A sAM4 B550 4xDDR4 M.2 HDMI-DVI-VGA Wi-Fi!!!BT mATX
		3700,00
		Материнcька плата ASUS PRIME_B550M-K sAM4 B550 4xDDR4 M.2 HDMI-DVI-VGA mATX
		3400,00
		Материнcька плата ASUS STRIX_B550-E_GAMING sAM4 B550 4xDDR4 M.2 HDMI-DP Wi-Fi!!!BT ATX
		7800,00
		Материнcька плата ASUS STRIX_B550-F_GAM_WI-FI sAM4 B550 4xDDR4 M.2 HDMI-DP Wi-Fi!!!BT ATX
		6100,00
		Материнcька плата ASUS STRIX_B550-F_GAMING sAM4 B550 4xDDR4 M.2 HDMI-DP ATX
		5800,00
		Материнcька плата ASUS STRIX_B550-I_GAMING sAM4 B550 2xDDR4 M.2 HDMI-DP Wi-Fi!!!BT mITX
		6800,00
		Материнcька плата ASUS TUF_GAM_B550M-PLUS_WI-FI sAM4 B550 4xDDR4 M.2 HDMI-DP Wi-Fi!!!BT mATX
		5000,00
		Материнcька плата ASUS TUF_GAMING_B550-PLUS sAM4 B550 4xDDR4 M.2 HDMI-DP ATX
		4800,00
		Материнcька плата ASUS TUF_GAMING_B550M-PLUS sAM4  B550 4xDDR4 M.2 HDMI-DP mATX
		4600,00
		Материнська плата GIGABYTE B550 AORUS MASTER sAM4 B550 4xDDR4 HDMI M.2 802.11ax+BT5.0 SPDIF Type-C ATX
		9453,00
		Материнська плата GIGABYTE B550 AORUS PRO AC sAM4 B550 4xDDR4 HDMI M.2 802.11ac+BT4.2 SPDIF Type-C ATX
		6290,00
		Материнська плата GIGABYTE B550 AORUS PRO sAM4 B550 4xDDR4 HDMI M.2 SPDIF Type-C ATX
		6004,00
		Материнcька плата MSI MAG_B550M_BAZOOKA sAM4 B550 4xDDR4 HDMI-DP mATX
		5000,00
		Материнcька плата MSI B550M_PRO-VDH_WIFI sAM4 B550 4xDDR4 HDMI-DP-VGA mATX
		4600,00
		Материнcька плата MSI MAG_B550_TOMAHAWK sAM4 B550 4xDDR4 HDMI-DP ATX
		6100,00
		Материнcька плата MSI MAG_B550M_MORTAR sAM4 B550 4xDDR4 HDMI-DP mATX
		5300,00
		Материнcька плата MSI MAG_B550M_MORTAR_WIFI sAM4 B550 4xDDR4 HDMI-DP Wi-Fi!!!BT mATX
		5600,00
		Материнcька плата MSI MPG_B550_GAM_EDGE_WIFI sAM4 B550 4xDDR4 HDMI-DP ATX
		6500,00
		Материнська плата ASRock  X570 PHANTOM GAMING 4S sAM4 4xDDR4 HDMI M.2 ATX
		4500,00
		Материнська плата ASRock X570 CREATOR sAM4 4xDDR4 HDMI-DP 802.11ax+BT 5.0 SPDIF Thunderbolt ATX
		17015,00
		Материнська плата ASRock X570 Extreme4 sAM4 4xDDR4 HDMI M.2 SPDIF Type-C ATX
		7833,00
		Материнська плата ASRock X570 Phantom Gaming-ITX/TB3 sAM4 2xDDR4 HDMI-DP M.2 802.11ax+BT5.0 SPDIF Type-C mITX
		7477,00
		Материнська плата ASRock X570 Phantom Gaming 4 sAM4 4xDDR4 HDMI-DP M.2 ATX
		4827,00
		Материнська плата ASRock X570 PHANTOM GAMING X sAM4 4xDDR4 HDMI 802.11ax+BT 5.0 SPDIF Type-C ATX
		11910,00
		Материнська плата ASRock X570 Pro4 sAM4 4xDDR4 HDMI-DP M.2 Type-C ATX
		5080,00
		Материнська плата ASRock X570 Steel Legend sAM4 4xDDR4 HDMI-DP M.2 SPDIF Type-C ATX
		6333,00
		Материнська плата ASRock X570 Taichi sAM4 4xDDR4 HDMI M.2 802.11ax+BT5.0 SPDIF Type-C ATX
		9924,00
		Материнська плата ASRock X570M Pro4 sAM4 4xDDR4 HDMI-DP M.2 Type-C mATX
		6187,00
		Материнcкая плата ASUS CROSSHAIR_VIII_FORMULA sAM4 X570 4xDDR4 PCIe 4.0 Wi-Fi!!!BT ATX
		16080,00
		Материнcька плата ASUS CROSSHAIR_VIII_HERO sAM4 X570 4xDDR4 PCIe 4.0 HDMI-DP ATX
		12470,00
		Материнcька плата ASUS CROSSHAIR_VIII_HERO_WIFI sAM4 X570 4xDDR4 PCIe 4.0 HDMI-DP Wi-Fi!!!BT ATX
		14400,00
		Материнcька плата ASUS PRIME_X570-P sAM4 X570 4xDDR4 PCIe 4.0 HDMI ATX
		5230,00
		Материнcька плата ASUS PRIME_X570-PRO sAM4 X570 4xDDR4 PCIe 4.0 HDMI-DP ATX
		7640,00
		Материнcька плата ASUS ROG_STRIX_X570-F_GAMING sAM4 X570 4xDDR4 PCIe 4.0 HDMI-DP ATX
		8290,00
		Материнcька плата ASUS STRIX_X570-E_GAMING sAM4 X570 4xDDR4 PCIe 4.0 HDMI-DP Wi-Fi!!!BT ATX
		10500,00
		Материнcька плата ASUS STRIX_X570-I_GAMING sAM4 X570 2xDDR4 PCIe 4.0 HDMI-DP Wi-Fi!!!BT mITX
		7640,00
		Материнcька плата ASUS TUF_GAM_X570-PLUS_WIFI sAM4 X570 4xDDR4 PCIe 4.0 HDMI-DP Wi-Fi!!!BT ATX
		7350,00
		Материнcька плата ASUS TUF_GAMING_X570-PLUS sAM4 X570 4xDDR4 PCIe 4.0 HDMI-DP ATX
		6380,00
		Материнська плата Biostar Racing X570GT sAM4 X570 4xDDR4 HDMI-DVI, M.2, mATX
		4079,00
		Материнська плата Biostar Racing X570GTA sAM4 X570 4xDDR4 HDMI-VGA, M.2, ATX
		4699,00
		Материнська плата GIGABYTE X570 GAMING X sAM4 4xDDR4 HDMI M.2 ATX
		5355,00
		Материнська плата GIGABYTE X570 UD sAM4 4xDDR4 HDMI M.2 ATX
		4591,00
		Материнcька плата MSI MAG_X570_TOMAHAWK_WIFI sAM4 X570 4xDDR4 PCIe 4.0 HDMI Wi-Fi!!!BT ATX
		0,00
		Материнcька плата MSI MEG_X570_GODLIKE sAM4 X570 4xDDR4 PCIe 4.0 Wi-Fi!!!BT EATX
		21440,00
		Материнcька плата MSI MEG_X570_UNIFY sAM4 X570 4xDDR4 PCIe 4.0 Wi-Fi!!!BT ATX
		8000,00
		Материнcька плата MSI MPG_X570_GAM_EDGE_WI-FI sAM4 X570 4xDDR4 PCIe 4.0 Wi-Fi!!!BT HDMI ATX
		6030,00
		Материнcька плата MSI MPG_X570_GAMING_PLUS sAM4 X570 4xDDR4 PCIe 4.0 HDMI ATX
		5100,00
		Материнcька плата MSI MPG_X570_GAMPRO_CAR_WIFI sAM4 X570 4xDDR4 PCIe 4.0 Wi-Fi!!!BT HDMI ATX
		8550,00
		Материнcька плата MSI PRESTIGE_X570_CREATION sAM4 X570 4xDDR4 PCIe 4.0 Wi-Fi!!!BT EATX
		14210,00
		Материнcька плата MSI X570-A_PRO sAM4 X570 4xDDR4 PCIe 4.0 HDMI ATX
		4560,00
	""".trimIndent()

	val list1 = str1.split('\n')
	for (i in 0 until list1.size step 2) {
		println(list1[i].substring("Материнська плата ".length) + "\t" + list1[i+1])
	}


//	runApplication<WeatherApplication>()
}
