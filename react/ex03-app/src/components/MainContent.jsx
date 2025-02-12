import ContentGrid from "./ContentGrid.jsx";

export default function MainContent() {
  return (
    <div className="bg-[#f3f5f7] grow h-[750px]">
      <div className="lex grow basis-full px-[20px] py-[30px]">
        <h1 className="font-bold text-[32px]">추천 제품</h1>
      </div>
      <div className="flex flex-row flex-wrap px-[20px] gap-[30px] justify-center">
        <ContentGrid
          name="프리미엄 노트북"
          price="1,599,000원"
          description="최신 사양의 고성능 노트북"
          category="전자기기"
        />
        <ContentGrid
          name="무선 헤드폰"
          price="299,000원"
          description="프리미엄 사운드의 노이즈 캔슬링 헤드폰"
          category="전자기기"
        />
        <ContentGrid
          name="스마트 워치"
          price="399,000원"
          description="피트니스 트래킹과 스마트 연결 가능"
          category="액세사리"
        />
        <div className="lg:hidden md:invisible block">
          <ContentGrid
            name="스마트 워치"
            price="399,000원"
            description="피트니스 트래킹과 스마트 연결 가능"
            category="액세사리"
          />
        </div>
      </div>
    </div>
  );
}
