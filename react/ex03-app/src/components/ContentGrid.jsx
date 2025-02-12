export default function ContentGrid(props) {
  return (
    <div className="bg-[#ffffff] rounded-[10px] flex flex-col grow p-[20px] md:basis-2/5 lg:basis-0">
      <div className="flex flex-row justify-between text-[18px]">
        <div className="flex font-bold">{props.name}</div>
        <div className="text-[18px] font-bold text-[#2664eb]">
          {props.price}
        </div>
      </div>
      <div className="py-[20px] text-[16px]">{props.description}</div>
      <div className="flex flex-row justify-between">
        <div className="h-[40px] leading-[40px] px-[10px] rounded-[10px] bg-[#eff7ff] text-[#2664eb]">
          {props.category}
        </div>
        <button className="bg-[#2664eb] text-[#ffffff] p-[10px] rounded-[10px] border-none">
          장바구니 담기
        </button>
      </div>
    </div>
  );
}
